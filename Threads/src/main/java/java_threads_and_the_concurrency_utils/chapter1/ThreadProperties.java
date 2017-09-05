package java_threads_and_the_concurrency_utils.chapter1;

/**
 * @author Sergey Zhernovoy
 * create on 04.09.2017.
 */

public class ThreadProperties implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new ThreadProperties());
        Thread namedThread = new Thread(new ThreadProperties(),"This is second thread");
        System.out.println("First thread: " + th.getName());
        System.out.println("Second thread: "+ namedThread.getName());
        System.out.println("Thread's unique id: "+namedThread.getId());
        System.out.println("How are you health ? "+"Thread's name: "+ namedThread.getName()+" health: "+namedThread.isAlive());
        namedThread.setDaemon(true);
        namedThread.start();
        //Thread.sleep(500);
        System.out.println("And now - How are you health ? "+"Thread's name: "+ namedThread.getName()+" health: "+namedThread.isAlive());
        System.out.println("How are you state ? "+"Thread's name: "+ namedThread.getName()+" state: "+namedThread.getState());
        System.out.println("Current priority ? "+"Thread's name: "+ namedThread.getName()+" priority: "+namedThread.getPriority());
        namedThread.setPriority(10);
        System.out.println("Current priority ? "+"Thread's name: "+ namedThread.getName()+" priority: "+namedThread.getPriority());
        System.out.println("Is this deamon thread ? "+"Thread's name: "+ namedThread.getName()+" daemon: "+namedThread.isDaemon());
//        namedThread.start(); в этот момент нити уже не существует



    }

    @Override
    public void run() {
        System.out.println("Hello first thread!!!");
    }
}

    