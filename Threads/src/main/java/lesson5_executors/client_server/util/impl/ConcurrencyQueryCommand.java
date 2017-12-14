package lesson5_executors.client_server.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 14.12.2017.
 */

import lesson5_executors.client_server.util.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyQueryCommand extends Command {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyQueryCommand.class);

    public ConcurrencyQueryCommand(String[] commandData) {
        super(commandData);
    }

    @Override
    public String execute() {
        return null;
    }
}

    