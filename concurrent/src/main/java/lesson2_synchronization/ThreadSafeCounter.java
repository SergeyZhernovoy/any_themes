package lesson2_synchronization;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sergey Zhernovoy
 * create on 03.11.2017.
 */

public class ThreadSafeCounter implements Runnable {

    private final AtomicInteger counter = new AtomicInteger(0);

    public int getCount(){
        return counter.get();
    }

    @Override
    public void run() {

        while(counter.get() < 100){
            System.out.println(Thread.currentThread().getName()+" increase counter to " + counter.get());
            counter.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter();
        Thread thA = new Thread(threadSafeCounter,"Thread A");
        Thread thB = new Thread(threadSafeCounter,"Thread B");
        Thread thC = new Thread(threadSafeCounter,"Thread C");
        thA.start();
        thB.start();
        thC.start();
    }

}

    