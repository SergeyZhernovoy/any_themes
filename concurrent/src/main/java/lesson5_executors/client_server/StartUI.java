package lesson5_executors.client_server;

import lesson5_executors.client_server.clients.concurrency.ConcurrentClient;
import lesson5_executors.client_server.clients.serial.Client;
import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.wdi.WDIDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;

public class StartUI {

    public  static void ClientPoolSerial(){
        final int NUM_CLIENTS=5;
        WDIDAO dao=WDIDAO.getDAO();
        for (int i=1; i<=NUM_CLIENTS; i++) {
            System.out.println("Number of Simultaneous Clients: "+i);
            Thread[] threads= new Thread[i];
            Client client=new Client(dao);
            for (int j=0; j<i; j++) {
                threads[j] = new Thread(client);
                threads[j].start();
            }

            for (int j=0; j<i; j++) {
                try {
                    threads[j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try (Socket echoSocket = new Socket("localhost",Constants.SERIAL_PORT);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            StringWriter writer = new StringWriter();
            writer.write("z");
            writer.write(";");

            String command = writer.toString();
            out.println(command);
            String output = in.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ClientPoolParallel(){
        final int NUM_CLIENTS=5;
        WDIDAO dao=WDIDAO.getDAO();
        for (int i=1; i<=NUM_CLIENTS; i++) {
            System.out.println("Number of Simultaneous Clients: "+i);
            Thread[] threads= new Thread[i];
            ConcurrentClient client=new ConcurrentClient(dao);
            for (int j=0; j<i; j++) {
                threads[j] = new Thread(client);
                threads[j].start();
            }

            for (int j=0; j<i; j++) {
                try {
                    threads[j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try (Socket echoSocket = new Socket("localhost", Constants.CONCURRENT_PORT);
                 PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                StringWriter writer = new StringWriter();
                writer.write("s");
                writer.write(";");

                String command = writer.toString();
                out.println(command);
                String output = in.readLine();
                System.err.println(output);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try (Socket echoSocket = new Socket("localhost", Constants.CONCURRENT_PORT);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            StringWriter writer = new StringWriter();
            writer.write("z");
            writer.write(";");

            String command = writer.toString();
            out.println(command);
            String output = in.readLine();
            System.err.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //StartUI.ClientPoolSerial();
        StartUI.ClientPoolParallel();
    }
}
