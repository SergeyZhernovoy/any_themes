package lesson5_executors.client_server.util.cache;

import java.util.concurrent.TimeUnit;

public class CleanCacheTask implements Runnable {
    /**
     * Cache to clean
     */
    private ParallelCache cache;

    /**
     * Constructor of the class
     * @param cache Cache to clean
     */
    public CleanCacheTask(ParallelCache cache) {
        this.cache = cache;
    }

    @Override
    /**
     * Main method of the clean task
     */
    public void run() {
        try {
            while (!Thread.currentThread().interrupted()) {
                TimeUnit.SECONDS.sleep(10);
                cache.cleanCache();
            }
        } catch (InterruptedException e) {

        }
    }
}
