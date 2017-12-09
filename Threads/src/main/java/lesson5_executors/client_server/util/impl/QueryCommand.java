package lesson5_executors.client_server.util.impl;/*
 * Created Sergey Zhernovoy
 * on 09.12.2017 at 15:35
 */

import lesson5_executors.client_server.util.Command;
import lesson5_executors.client_server.wdi.WDIDAO;

public class QueryCommand extends Command {
    /**
     * Constructor of the class
     * @param command String that represents the command
     */
    public QueryCommand (String [] command) {
        super(command);
    }

    @Override
    /**
     * Method that executes the command
     */
    public String execute() {

        WDIDAO dao= WDIDAO.getDAO();


        if (command.length==3) {
            return dao.query(command[1], command[2]);
        } else if (command.length==4) {
            try {
                return dao.query(command[1], command[2], Short.parseShort(command[3]));
            } catch (Exception e) {
                return "ERROR;Bad Command";
            }
        } else {
            return "ERROR;Bad Command";
        }
    }
}
