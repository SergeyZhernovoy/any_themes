package lesson5_executors.client_server.util.impl;/**
 * @author Sergey Zhernovoy
 * create on 14.12.2017.
 */

import lesson5_executors.client_server.servers.concurrent.ConcurrentServer;
import lesson5_executors.client_server.util.ConcurrencyCommand;
import lesson5_executors.client_server.wdi.WDIDAO;

public class ConcurrencyReportCommand extends ConcurrencyCommand {

    public ConcurrencyReportCommand(String[] commandData, final ConcurrentServer concurrentServer) {
        super(commandData,concurrentServer);
    }

    @Override
    public String execute() {
        WDIDAO dao=WDIDAO.getDAO();
        return dao.report(command[1]);
    }
}

    