package lesson5_executors.client_server_with_cancel.util;

import java.net.Socket;

/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

public interface Command extends Runnable, Comparable<Command> {

    String execute();

    String getUserName();

    Socket getSocket();

    byte getPriority();

}

    