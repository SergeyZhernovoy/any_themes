package lesson5_executors.client_server_with_cancel.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

import lesson5_executors.client_server_with_cancel.server.Server;
import lesson5_executors.client_server_with_cancel.util.AbstractCommand;

import java.net.Socket;


public class QueryCommand extends AbstractCommand{

    public QueryCommand(String[] command, Socket socket, Server server) {
        super(command, socket, server);
    }

    @Override
    public String execute() {
        String result = "ERROR;Bad Command";
        if (command.length==5) {
            result =  dao.query(command[3], command[4]);
        } else {
            if (command.length==6) {
                try {
                    result = dao.query(command[3], command[4], Short.parseShort(command[5]));
                } catch (Exception e) {
                    return "ERROR;Bad Command";
                }
            }
        }
        return result;
    }
}

    