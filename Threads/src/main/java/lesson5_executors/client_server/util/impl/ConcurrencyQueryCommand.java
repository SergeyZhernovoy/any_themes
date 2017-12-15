package lesson5_executors.client_server.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 14.12.2017.
 */

import lesson5_executors.client_server.servers.concurrent.ConcurrentServer;
import lesson5_executors.client_server.util.Command;
import lesson5_executors.client_server.util.CommandConccurency;
import lesson5_executors.client_server.wdi.WDIDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyQueryCommand extends CommandConccurency {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyQueryCommand.class);

    public ConcurrencyQueryCommand(String[] commandData, final ConcurrentServer server) {
        super(commandData,server);
    }
    @Override
    /**
     * Method that executes the query
     */
    public String execute() {

        WDIDAO dao= WDIDAO.getDAO();
        String result = "ERROR;Bad Command";
        if (command.length==3) {
            result =  dao.query(command[1], command[2]);
        } else if (command.length==4) {
            try {
                result =  dao.query(command[1], command[2], Short.parseShort(command[3]));
            } catch (Exception e) {

            }
        }
        return result;
    }
}

    