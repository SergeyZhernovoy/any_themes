package lesson5_executors.client_server_with_cancel.server;/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.util.cache.ParallelCache;
import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server.wdi.WDIDAO;
import lesson5_executors.client_server_with_cancel.server.executor.ServerTask;
import lesson5_executors.client_server_with_cancel.util.Command;
import lesson5_executors.client_server_with_cancel.util.impl.CancelCommand;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {
    /**
     * Cache to get a better performance
     */
    private ParallelCache cache;
    /**
     * Attribute to control the status of the server
     */
    private volatile boolean stopped = false;
    /**
     * Method that store the pending request the server has to process
     */
    private LinkedBlockingQueue<Socket> pendingConnections;
    /**
     * HashMap that stores the Future instances of the tasks executed by the
     * server. We use this HashMap to cancel the tasks
     */
    private ConcurrentMap<String, ConcurrentMap<Command,ServerTask<?>>> taskController;
    /**
     * Thread that will convert the requests to commands
     */
    private Thread requestThread;
    /**
     * The Runnable that convert the requests to commands
     */
    private RequestTask task;
    /**
     * Socket to accept the server requests
     */
    private ServerSocket serverSocket;

    final static WDIDAO dao;

    static {
        dao = WDIDAO.getDAO();
    }

    public Server(){
        Logger.initialize();
        this.cache = new ParallelCache();
        this.pendingConnections = new LinkedBlockingQueue<>();
        this.taskController = new ConcurrentHashMap<>();
        this.task = new RequestTask(this.pendingConnections,this.taskController,this);
        this.requestThread = new Thread(task);
        System.out.println("Initialization completed.");
    }

    public void startServer() throws IOException {
        this.requestThread.start();
        this.serverSocket = new ServerSocket(Constants.CONCURRENT_PORT);
        do {
            try{
                Socket clientSocket = this.serverSocket.accept();
                this.pendingConnections.put(clientSocket);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!this.stopped);
        finishServer();
    }

    public ParallelCache getCache() {
        return cache;
    }

    public void shutdown(){
        this.stopped = true;
        try{
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void finishServer() {

        System.out.println("Shutting down the server ... ");
        this.task.shutdown();
        this.task.terminate();
        System.out.println("Shutting down Request task");
        requestThread.interrupt();
        System.out.println("Request task ok");
        System.out.println("Closing socket");
        System.out.println("Shutting down logger");
        Logger.sendMessage("Shutting down the logger");
        Logger.shutdown();
        System.out.println("Logger ok");
        System.out.println("Main server thread ended");
        System.out.println("Shutting down cache");
        this.cache.shutdown();
        System.out.println("Cache ok" + new Date());
    }

    /**
     * This method is executed to cancel all the tasks of a user
     *
     * @param userName
     * Name of the user
     */
    public void cancelTasks(String userName) {

        ConcurrentMap<Command, ServerTask<?>> userTasks = taskController.get(userName);
        if (userTasks == null) {
            return;
        }
        int taskNumber = 0;
        Iterator<ServerTask<?>> it = userTasks.values().iterator();
        while (it.hasNext()) {
            ServerTask<?> task = it.next();
            Command command = task.getCommand();
            if (!(command instanceof CancelCommand) && task.cancel(true)) {
                taskNumber++;
                Logger.sendMessage(
                        "Task with code " + command.hashCode() + "cancelled: " + command.getClass().getSimpleName());
                it.remove();
            }
        }
        String message = taskNumber + " tasks has been cancelled.";
        Logger.sendMessage(message);

    }


    /**
     * This method is used to delete a finished tasks of the Hashmap with the
     * futures that controls the execution of the tasks
     *
     * @param userName
     * Name of the user
     */
    public void finishTask(String userName, Command command) {

        ConcurrentMap<Command, ServerTask<?>> userTasks = this.taskController.get(userName);
        userTasks.remove(command);
        String message = "Task with code " + command.hashCode() + " has finished";
        Logger.sendMessage(message);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startServer();
    }
}

    