package lesson5_executors.client_server.clients.serial;

import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.wdi.WDI;
import lesson5_executors.client_server.wdi.WDIDAO;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;

public class Client implements Runnable{
    private WDIDAO dao;

    public Client(WDIDAO dao){
        this.dao = dao;
    }

    @Override
    public void run() {
        List<WDI> data = dao.getData();
        Random randomGenerator = new Random();

        for (int i = 0 ; i < 10; i++){
            for (int j = 0; j < 9; j++){
                try(Socket echoSocket = new Socket("localhost", Constants.SERIAL_PORT);
                    PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))){
                    WDI wdi = data.get(randomGenerator.nextInt(data.size()));
                    StringWriter writer = new StringWriter();
                    writer.write("q");
                    writer.write(";");
                    writer.write(wdi.getCountryCode());
                    writer.write(";");
                    writer.write(wdi.getIndicatorCode());
                    String command = writer.toString();
                    out.println(command);
                    String output = in.readLine();
                    System.err.println("OUTPUT: " + output);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try (Socket echoSocket = new Socket("localhost", Constants.SERIAL_PORT);
                 PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                WDI wdi = data.get(randomGenerator.nextInt(data.size()));
                StringWriter writer = new StringWriter();
                writer.write("r");
                writer.write(";");
                writer.write(wdi.getIndicatorCode());
                String command = writer.toString();
                out.println(command);
                String output = in.readLine();
                System.err.println("OUTPUT: "+output);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
