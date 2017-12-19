package lesson5_executors.client_server.servers.concurrent;/**
 * @author Sergey Zhernovoy
 * create on 12.12.2017.
 */

import lesson5_executors.client_server.util.ConcurrencyCommand;
import lesson5_executors.client_server.util.cache.ParallelCache;
import lesson5_executors.client_server.util.impl.*;
import lesson5_executors.client_server.util.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestTask implements Runnable {
    private Socket clientSocket;
    private ParallelCache parallelCache;
    private final ConcurrentServer concurrentServer;
    public RequestTask(final Socket socket, final ParallelCache parallelCache, final ConcurrentServer server) {
        this.clientSocket = socket;
        this.parallelCache = parallelCache;
        this.concurrentServer = server;
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
                ConcurrencyCommand command;
                String[] commandData = line.split(";");
                System.err.println("Command: " + commandData[0]);
                switch(commandData[0]){
                    case "q":
                        System.err.println("Query");
                        command = new ConcurrencyQueryCommand(commandData, concurrentServer);
                        break;
                    case "r":
                        System.err.println("Report");
                        command = new ConcurrencyReportCommand(commandData,concurrentServer);
                        break;
                    case "s":
                        System.err.println("Status");
                        command = new ConcurrencyStatusCommand(commandData,concurrentServer);
                        break;
                    case "z":
                        System.err.println("Stop");
                        command = new ConcurrencyStopCommand(commandData,concurrentServer);
                        break;
                    default:
                        System.err.println("Error");
                        command = new ConcurrencyErrorCommand(commandData,concurrentServer);
                }
                ret  = command.execute();
                if(command.isCacheable()){
                    this.parallelCache.put(line,ret);
                }
            } else {
                Logger.sendMessage("Command "+line+" was found in the cache");
            }
            System.err.println(ret);
            out.println(ret);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

    