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

public class ConcurrencyReportCommand extends CommandConccurency {

    public ConcurrencyReportCommand(String[] commandData, final ConcurrentServer concurrentServer) {
        super(commandData,concurrentServer);
    }

    @Override
    public String execute() {
        WDIDAO dao=WDIDAO.getDAO();
        return dao.report(command[1]);
    }
}

    