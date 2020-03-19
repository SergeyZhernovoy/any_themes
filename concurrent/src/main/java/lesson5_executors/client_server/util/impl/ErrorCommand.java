package lesson5_executors.client_server.util.impl;/*
 * Created Sergey Zhernovoy
 * on 09.12.2017 at 15:36
 */

import lesson5_executors.client_server.util.Command;

public class ErrorCommand extends Command {
    /**
     * Constructor of the class
     * @param command String that represents the command
     */
    public ErrorCommand(String[] command) {
        super(command);
    }

    @Override
    /**
     * Method that executes the command
     */
    public String execute() {
        return "Unknown command: "+command[0];
    }
}
