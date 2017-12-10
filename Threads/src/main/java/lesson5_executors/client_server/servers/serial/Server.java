package lesson5_executors.client_server.servers.serial;

import lesson5_executors.client_server.util.Command;
import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.util.impl.ErrorCommand;
import lesson5_executors.client_server.util.impl.QueryCommand;
import lesson5_executors.client_server.util.impl.ReportCommand;
import lesson5_executors.client_server.util.impl.StopCommand;
import lesson5_executors.client_server.wdi.WDIDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Sergey Zhernovoy
 * create on 10.12.2017.
 */

public class Server {
    private WDIDAO wdidao;
    boolean interruptServer;
    private ServerSocket serverSocket;


    public Server() throws IOException {
        this.interruptServer = false;
        this.wdidao = WDIDAO.getDAO();
        this.serverSocket = new ServerSocket(Constants.SERIAL_PORT);
        System.out.println("Initialization complete");
    }

    public void execute(){
        do{
            try(Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));){
                String line = in.readLine();
                Command command;
                String[] commandData = line.split(";");
                System.err.println("Command: " + commandData[0]);
                switch (commandData[0]){
                    case "q":
                            System.err.println("Query");
                            command = new QueryCommand(commandData);
                            break;
                    case "r":
                            System.err.println("Report");
                            command = new ReportCommand(commandData);
                            break;
                    case "z":
                            System.err.println("Stop");
                            command = new StopCommand(commandData);
                            this.interruptServer = true;
                            break;
                    default:
                            System.err.println("Error");
                            command = new ErrorCommand(commandData);
                }
                String response = command.execute();
                System.err.println(response);
                out.println(response);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } while(!interruptServer);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.execute();
    }

}

    