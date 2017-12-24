package lesson5_executors.client_server_with_cancel.server;/**
 * @author Sergey Zhernovoy
 * create on 22.12.2017.
 */

import lesson5_executors.client_server.util.cache.ParallelCache;
import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server_with_cancel.server.executor.ServerExecutor;
import lesson5_executors.client_server_with_cancel.server.executor.ServerTask;
import lesson5_executors.client_server_with_cancel.util.Command;
import lesson5_executors.client_server_with_cancel.util.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestTask implements Runnable{

    private LinkedBlockingQueue<Socket> pendingConnections;

    private ServerExecutor executor;

    private ConcurrentMap<String,ConcurrentMap<Command,ServerTask<?>>> taskController;

    private final Server server;

    public RequestTask(LinkedBlockingQueue<Socket> pendingConnections, ConcurrentMap<String, ConcurrentMap<Command, ServerTask<?>>> taskController, final Server server) {
        this.pendingConnections = pendingConnections;
        this.taskController = taskController;
        this.server = server;
        this.executor = new ServerExecutor(server);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().interrupted()) {
                try {
                    Socket clientSocket = pendingConnections.take();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String line = in.readLine();

                    Logger.sendMessage(line);

                    Command command;

                    ParallelCache cache = server.getCache();
                    String ret = cache.get(line);
                    if (ret == null) {
                        String[] commandData = line.split(";");
                        System.out.println("Command: " + commandData[0]);
                        switch (commandData[0]) {
                            case "q":
                                System.out.println("Query");
                                command = new QueryCommand(commandData, clientSocket,server);
                                break;
                            case "r":
                                System.out.println("Report");
                                command = new ReportCommand(commandData, clientSocket,server);
                                break;
                            case "s":
                                System.out.println("Status");
                                command = new StatusCommand(commandData, clientSocket,server,executor);
                                break;
                            case "z":
                                System.out.println("Stop");
                                command = new StopCommand(commandData, clientSocket,server);
                                break;
                            case "c":
                                System.out.println("Cancel");
                                command = new CancelCommand(commandData,clientSocket,server);
                                break;
                            default:
                                System.out.println("Error");
                                command = new ErrorCommand(commandData, clientSocket,server);
                                break;
                        }

                        ServerTask<?> controller = (ServerTask<?>)executor.submit(command);
                        storeController(command.getUserName(), controller, command);
                    } else {
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                        out.println(ret);
                        clientSocket.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            // No Action Required
        }
    }

    private void storeController(String userName, ServerTask<?> controller, Command command) {
        taskController.computeIfAbsent(userName, k -> new ConcurrentHashMap<>()).put(command, controller);
    }

    /**
     * Method that shutdown the task
     */
    public void shutdown() {
        String message="Request Task: " +pendingConnections.size()  + " pending connections.";
        Logger.sendMessage(message);
        executor.shutdown();
    }

    public void terminate() {
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
            executor.writeStatistics();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ServerExecutor getExecutor() {
        return executor;
    }
}

    