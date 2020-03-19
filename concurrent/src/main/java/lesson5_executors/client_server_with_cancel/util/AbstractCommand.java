package lesson5_executors.client_server_with_cancel.util;

import lesson5_executors.client_server.util.cache.ParallelCache;
import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server.wdi.WDIDAO;
import lesson5_executors.client_server_with_cancel.server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

public abstract class AbstractCommand implements Command {

    protected String[] command;

    private String userName;

    private byte priority;

    private Socket socket;

    protected final Server server;

    private boolean isCacheable;

    protected static WDIDAO dao;

    static {
        dao = WDIDAO.getDAO();
    }

    public AbstractCommand(String[] command, Socket socket, Server server) {
        this.command = command;
        this.userName = command[1];
        this.priority = Byte.parseByte(command[2]);
        this.socket = socket;
        this.server = server;
        setCacheable(true);
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

        String message = "Running a task: Username: "
                + getUserName()
                + "; Priority: "
                + getPriority();
        Logger.sendMessage(message);

        String ret = execute();

        ParallelCache cache = this.server.getCache();
        if(isCacheable){
            cache.put(String.join(";",command),ret);
        }

        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println(ret);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ret);
    }

    @Override
    public abstract String execute();

    @Override
    public int compareTo(Command command) {
        return Byte.compare(command.getPriority(),this.getPriority());
    }

    @Override
    public byte getPriority() {
        return priority;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public boolean isCacheable() {
        return isCacheable;
    }

    public void setCacheable(boolean cacheable) {
        isCacheable = cacheable;
    }
}

    