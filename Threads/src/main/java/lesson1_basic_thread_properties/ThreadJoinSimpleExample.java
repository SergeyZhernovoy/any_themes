package lesson1_basic_thread_properties;/**
 * @author Sergey Zhernovoy
 * create on 04.11.2017.
 */

public class ThreadJoinSimpleExample {

    private Thread t;


    public ThreadJoinSimpleExample(String name) {
        Runnable runnable = ()->{
            for(int index = 5 ; index > 0; index--){
                try {
                    System.out.println("thread "+ name + ":" + index);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + name+" exit");
            }
        };
        t = new Thread(runnable,name);
        t.start();
    }

    public Thread getT() {
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinSimpleExample th1 = new ThreadJoinSimpleExample("First");
        ThreadJoinSimpleExample th2 = new ThreadJoinSimpleExample("Second");
        ThreadJoinSimpleExample th3 = new ThreadJoinSimpleExample("Third");

        System.out.println("Thread first is run: "+ th1.getT().isAlive());
        System.out.println("Thread second is run: "+ th2.getT().isAlive());
        System.out.println("Thread third is run: "+ th3.getT().isAlive());

        System.out.println("Waiting are exiting processing");
        th1.getT().join();
        th2.getT().join();
        th3.getT().join();

        System.out.println("Thread first is run: "+ th1.getT().isAlive());
        System.out.println("Thread second is run: "+ th2.getT().isAlive());
        System.out.println("Thread third is run: "+ th3.getT().isAlive());

        System.out.println("Main thread is exit");

    }
}

    