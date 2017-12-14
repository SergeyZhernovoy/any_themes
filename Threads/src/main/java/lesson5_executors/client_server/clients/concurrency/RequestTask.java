package lesson5_executors.client_server.clients.concurrency;/**
 * @author Sergey Zhernovoy
 * create on 12.12.2017.
 */

import lesson5_executors.client_server.servers.concurrent.ParallelCache;
import lesson5_executors.client_server.util.Command;
import lesson5_executors.client_server.util.Logger;
import lesson5_executors.client_server.util.impl.ConcurrencyErrorCommand;
import lesson5_executors.client_server.util.impl.ConcurrencyQueryCommand;
import lesson5_executors.client_server.util.impl.ConcurrencyReportCommand;
import lesson5_executors.client_server.util.impl.ConcurrencyStopCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestTask implements Runnable {
    private Socket clientSocket;
    private ParallelCache parallelCache;
    public RequestTask(final Socket socket, final ParallelCache parallelCache) {
        this.clientSocket = socket;
        this.parallelCache = parallelCache;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try(PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String line = in.readLine();
            Logger.sendMessage(line);
            String ret = parallelCache.get(line);
            if(ret == null){
                Command command;
                String[] commandData = line.split(";");
                System.err.println("Command: " + commandData[0]);
                switch(commandData[0]){
                    case "q":
                        System.err.println("Query");
                        command = new ConcurrencyQueryCommand(commandData);
                        break;
                    case "r":
                        System.err.println("Report");
                        command = new ConcurrencyReportCommand(commandData);
                        break;
                    case "z":
                        System.err.println("Stop");
                        command = new ConcurrencyStopCommand(commandData);
                        break;
                    default:
                        System.err.println("Error");
                        command = new ConcurrencyErrorCommand(commandData);
                }
                ret  = command.execute();
                if(command.isCacheble()){

                }



            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    