package lesson5_executors.client_server.util.impl;/*
 * Created Sergey Zhernovoy
 * on 09.12.2017 at 15:35
 */

import lesson5_executors.client_server.util.Command;
import lesson5_executors.client_server.wdi.WDIDAO;

public class ReportCommand extends Command {
    /**
     * Constructor of the class
     * @param command String that represents the command
     */
    public ReportCommand (String [] command) {
        super(command);
    }

    @Override
    /**
     * Method that executes the command
     */
    public String execute() {

        WDIDAO dao=WDIDAO.getDAO();
        return dao.report(command[1]);
    }
}
