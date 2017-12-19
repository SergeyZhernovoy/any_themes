package lesson5_executors.client_server.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 14.12.2017.
 */

import lesson5_executors.client_server.servers.concurrent.ConcurrentServer;
import lesson5_executors.client_server.util.ConcurrencyCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyStopCommand extends ConcurrencyCommand {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyStopCommand.class);

    public ConcurrencyStopCommand(String[] commandData, ConcurrentServer server) {
        super (commandData,server);
        setCacheable(false);
    }

    @Override
    /**
     * Method that executes the command
     */
    public String execute() {
        //ConcurrentServer.shutdown();
        this.server.shutdown();
        return "Server stopped";
    }
}

    