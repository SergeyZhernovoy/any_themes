package lesson5_executors.client_server.util.logger;

import lesson5_executors.client_server.util.Constants;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Sergey Zhernovoy
 * create on 14.12.2017.
 */


public class Logger {
    /**
     * Queue to store the log messages
     */
    private static ConcurrentLinkedQueue<String> logQueue = new ConcurrentLinkedQueue<>();

    /**
     * Thread to execute the Log Task
     */
    private static Thread thread;

    /**
     * Route to the file where we will write the log
     */
    private static final String LOG_FILE = Paths.get(Constants.LOG_ROUTE, "server.log").toString();

    /**
     * Block of code that initializes the Log task
     */
    static {
        LogTask task = new LogTask();
        thread = new Thread(task);
    }

    /**
     * Method that write a message in the log
     * @param message Message to write in the log
     */
    public static void sendMessage(String message) {
        logQueue.offer(new Date()+": "+message);
    }

    /**
     * Method that write all the messages in the queue to the file
     */
    public static void writeLogs() {
        String message;
        Path path = Paths.get(LOG_FILE);
        try (BufferedWriter fileWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {
            while ((message = logQueue.poll()) != null) {
                fileWriter.write(new Date()+": "+message);
                fileWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that clean the file
     */
    public static void initialize() {
        Path path = Paths.get(LOG_FILE);
        if (Files.exists(path)) {
            try (OutputStream out = Files.newOutputStream(path,StandardOpenOption.TRUNCATE_EXISTING)) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        thread.start();
    }

    /**
     * Method that stops the execution of the log system
     */
    public static void shutdown() {
        thread.interrupt();
    }
}

    