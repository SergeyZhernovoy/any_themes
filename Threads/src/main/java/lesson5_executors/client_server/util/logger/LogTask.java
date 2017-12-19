package lesson5_executors.client_server.util.logger;

import java.util.concurrent.TimeUnit;

public class LogTask implements Runnable {
    @Override
    /**
     * Main method of the task
     */
    public void run() {
        try {
            while (!Thread.currentThread().interrupted()) {
                TimeUnit.SECONDS.sleep(10);
                Logger.writeLogs();
            }
        } catch (InterruptedException e) {
        }
        Logger.writeLogs();
    }
}
