package lesson5_executors.client_server_with_cancel.client;

import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.wdi.WDI;
import lesson5_executors.client_server.wdi.WDIDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
    private String username;

    private ThreadPoolExecutor executor;

    public Client(String username, ThreadPoolExecutor executor) {
        this.username=username;
        this.executor=executor;
    }

    @Override
    public void run() {
        WDIDAO dao = WDIDAO.getDAO();
        List<WDI> data = dao.getData();
        Date globalStart, globalEnd;
        Random randomGenerator = new Random();

        globalStart = new Date();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                QueryTask task=new QueryTask(data,username);
                executor.submit(task);
            }
            ReportTask task=new ReportTask(data, username);
            executor.submit(task);
        }

        globalEnd = new Date();
        System.out.println("Total Time: "  + ((globalEnd.getTime() - globalStart.getTime()) / 1000)  + " seconds.");

    }

    public static void main(String[] args) {
        final int NUM_CLIENTS = 5;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
                .newFixedThreadPool(Runtime
                                        .getRuntime()
                                        .availableProcessors());

        for (int i = 1; i <= NUM_CLIENTS; i++) {
            System.out.println("Number of Simultaneous Clients: " + i);
            Thread[] threads = new Thread[i];
            for (int j = 0; j < i; j++) {
                String username = "USER_" + (j + 1);
                Client client = new Client(username,executor);
                threads[j] = new Thread(client);
                threads[j].start();
            }

            for (int j = 0; j < i; j++) {
                try {
                    threads[j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try (Socket echoSocket = new Socket("localhost",Constants.CONCURRENT_PORT);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            StringWriter writer = new StringWriter();
            writer.write("s");
            writer.write(";");
            writer.write("USER_1");
            writer.write(";");
            writer.write(String.valueOf(10));
            writer.write(";");

            String command = writer.toString();
            out.println(command);
            String output = in.readLine();
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Socket echoSocket = new Socket("localhost",Constants.CONCURRENT_PORT);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            StringWriter writer = new StringWriter();
            writer.write("c");
            writer.write(";");
            writer.write("USER_2");
            writer.write(";");
            writer.write(String.valueOf(10));
            writer.write(";");

            String command = writer.toString();
            out.println(command);
            String output = in.readLine();
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try (Socket echoSocket = new Socket("localhost", Constants.CONCURRENT_PORT);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            StringWriter writer = new StringWriter();
            writer.write("z");
            writer.write(";");
            writer.write("admin");
            writer.write(";");
            writer.write(String.valueOf(10));
            writer.write(";");

            String command = writer.toString();
            out.println(command);
            String output = in.readLine();
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

}
