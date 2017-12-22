package lesson5_executors.client_server_with_cancel.server.executor;

import lesson5_executors.client_server_with_cancel.util.Command;

import java.util.concurrent.FutureTask;

/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

public class ServerTask<V> extends FutureTask<V> implements Comparable<ServerTask<V>> {

    private Command command;

    /**
     * Creates a {@code FutureTask} that will, upon running, execute the
     * given {@code Runnable}, and arrange that {@code get} will return the
     * given result on successful completion.
     *
     * @param command the runnable task
     * @throws NullPointerException if the runnable is null
     */
    public ServerTask(Command command) {
        super(command, null);
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public int compareTo(ServerTask<V> otherTask) {
        return command.compareTo(otherTask.getCommand());
    }
}

    