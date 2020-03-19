package lesson5_executors.client_server.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 14.12.2017.
 */

import lesson5_executors.client_server.servers.concurrent.ConcurrentServer;
import lesson5_executors.client_server.util.ConcurrencyCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyErrorCommand extends ConcurrencyCommand {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyErrorCommand.class);

    public ConcurrencyErrorCommand(String[] commandData, final ConcurrentServer concurrentServer) {
        super(commandData,concurrentServer);
        setCacheable(false);
    }

    @Override
    public String execute() {
        return "Unknown command: "+command[0];
    }
}

    