package lesson5_executors.client_server_with_cancel.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server_with_cancel.server.Server;
import lesson5_executors.client_server_with_cancel.util.AbstractCommand;

import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class StatusCommand extends AbstractCommand {

    private ThreadPoolExecutor executor;

    public StatusCommand(String[] command, Socket socket, Server server, ThreadPoolExecutor executor) {
        super(command, socket, server);
        this.executor = executor;
        setCacheable(false);
    }

    @Override
    public String execute() {
        StringBuilder sb=new StringBuilder();
        sb.append("Server Status;");
        sb.append("Actived Threads: ");
        sb.append(String.valueOf(executor.getActiveCount()));
        sb.append(";");
        sb.append("Maximum Pool Size: ");
        sb.append(String.valueOf(executor.getMaximumPoolSize()));
        sb.append(";");
        sb.append("Core Pool Size: ");
        sb.append(String.valueOf(executor.getCorePoolSize()));
        sb.append(";");
        sb.append("Pool Size: ");
        sb.append(String.valueOf(executor.getPoolSize()));
        sb.append(";");
        sb.append("Largest Pool Size: ");
        sb.append(String.valueOf(executor.getLargestPoolSize()));
        sb.append(";");
        sb.append("Completed Task Count: ");
        sb.append(String.valueOf(executor.getCompletedTaskCount()));
        sb.append(";");
        sb.append("Task Count: ");
        sb.append(String.valueOf(executor.getTaskCount()));
        sb.append(";");
        sb.append("Queue Size: ");
        sb.append(String.valueOf(executor.getQueue().size()));
        sb.append(";");
        sb.append("Cache Size: ");
        sb.append(String.valueOf(server.getCache().getItemCount()));
        sb.append(";");
        Logger.sendMessage(sb.toString());
        return sb.toString();
    }
}

    