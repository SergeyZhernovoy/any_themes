package lesson5_executors.client_server.util.impl;

import lesson5_executors.client_server.servers.concurrent.ConcurrentServer;
import lesson5_executors.client_server.util.ConcurrencyCommand;
import lesson5_executors.client_server.util.logger.Logger;

import java.util.concurrent.ThreadPoolExecutor;

public class ConcurrencyStatusCommand extends ConcurrencyCommand {

    public ConcurrencyStatusCommand(String[] command, ConcurrentServer concurrentServer) {
        super(command, concurrentServer);
        setCacheable(false);
    }

    @Override
    public String execute() {
        StringBuilder sb=new StringBuilder();
        ThreadPoolExecutor executor= this.server.getExecutor();
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
        sb.append(String.valueOf(this.server.getParallelCache().getItemCount()));
        sb.append(";");
        Logger.sendMessage(sb.toString());
        return sb.toString();
    }
}
