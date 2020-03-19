package lesson5_executors.client_server.util.cache;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergey Zhernovoy
 * create on 12.12.2017.
 */

public class ParallelCache {
    /**
     * Hashmap to store the items of the cache
     */
    private ConcurrentHashMap<String, CacheItem> cache;

    /**
     * Task to clean the cache
     */
    private CleanCacheTask task;

    /**
     * Thread to execute the clean task
     */
    private Thread thread;

    /**
     * Max living time millis
     */
    public static int MAX_LIVING_TIME_MILLIS = 600_000;

    /**
     * Constructor of the class
     */
    public ParallelCache() {
        cache=new ConcurrentHashMap<>();
        task=new CleanCacheTask(this);
        thread=new Thread(task);
        thread.start();
    }

    /**
     * Method that stores an element in the cache
     * @param command Command to store
     * @param response Response to that command
     */
    public void put(String command, String response) {
        CacheItem item = new CacheItem(command, response);
        cache.put(command, item);

    }

    /**
     * Method that returns an element of the cache or null if it doesn't exists
     * @param command Command to look for in the cache
     * @return Response of that command
     */
    public String get (String command) {
        CacheItem item=cache.get(command);
        if (item==null) {
            return null;
        }
        item.setAccessDate(new Date());
        return item.getResponse();
    }

    public void cleanCache() {
        Date revisionDate = new Date();
        Iterator<CacheItem> iterator = cache.values().iterator();
        while (iterator.hasNext()) {
            CacheItem item = iterator.next();
            if (revisionDate.getTime() - item.getAccessDate().getTime() > MAX_LIVING_TIME_MILLIS) {
                iterator.remove();
            }
        }
    }

    /**
     * Method that shutdown the cache
     */
    public void shutdown() {
        thread.interrupt();
    }

    /**
     * Method that retuns the number of items in the cache
     * @return The number of items in the cache
     */
    public int getItemCount() {
        return cache.size();
    }

}

    