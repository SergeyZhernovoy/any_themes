package lesson5_executors.client_server.util;/**
 * @author Sergey Zhernovoy
 * create on 09.12.2017.
 */

public abstract class Command {

    protected String[] command;

    public Command(String[] command){
        this.command = command;
    }

    public abstract String execute();

    public boolean isCacheble() {
        return true;
    }
}

    