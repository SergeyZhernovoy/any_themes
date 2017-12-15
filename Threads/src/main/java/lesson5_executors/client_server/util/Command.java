package lesson5_executors.client_server.util;/**
 * @author Sergey Zhernovoy
 * create on 09.12.2017.
 */

public abstract class Command implements TaskExecute{

    protected String[] command;

    public Command(String[] command){
        this.command = command;
    }

    /**
     * Abstract method that executes the command
     * @return An String with the response of the command
     */
    public abstract String execute();
}

    