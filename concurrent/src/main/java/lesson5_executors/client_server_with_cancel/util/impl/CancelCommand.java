package lesson5_executors.client_server_with_cancel.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server_with_cancel.server.Server;
import lesson5_executors.client_server_with_cancel.util.AbstractCommand;

import java.net.Socket;

public class CancelCommand extends AbstractCommand {

    public CancelCommand(String[] command, Socket socket, Server server) {
        super(command, socket, server);
        setCacheable(false);
    }

    @Override
    public String execute() {
        this.server.cancelTasks(getUserName());
        String message = "Tasks of user "
                + getUserName()
                +" has been cancelled.";
        Logger.sendMessage(message);
        return message;
    }
}

    