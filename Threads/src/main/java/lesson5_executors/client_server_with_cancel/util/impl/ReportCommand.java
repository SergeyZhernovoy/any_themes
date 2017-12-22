package lesson5_executors.client_server_with_cancel.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

import lesson5_executors.client_server_with_cancel.server.Server;
import lesson5_executors.client_server_with_cancel.util.AbstractCommand;

import java.net.Socket;

public class ReportCommand extends AbstractCommand{

    public ReportCommand(String[] command, Socket socket, Server server) {
        super(command, socket, server);
    }

    @Override
    public String execute() {
        return dao.report(command[3]);
    }
}

    