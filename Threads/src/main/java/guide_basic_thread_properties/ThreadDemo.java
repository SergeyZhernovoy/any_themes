package guide_basic_thread_properties;/**
 * @author Sergey Zhernovoy
 * create on 05.09.2017.
 */

public class ThreadDemo {




    public static void main(String[] args) {
        boolean isDaemon = args.length !=0;
        Runnable runnable = ()-> {
            Thread thd = Thread.currentThread();
            while(true){
                System.out.printf("%s is %salive and in %s state%n",
                                    thd.getName(),
                                    thd.isAlive() ? "": "not ",
                                    thd.getState());
            }
        };
        Thread t1 = new Thread(runnable, "thd1");
        t1.setDaemon(isDaemon);
        System.out.printf("%s is %salive and in %s state%n",
                t1.getName(),
                t1.isAlive() ? "": "not ",
                t1.getState());

        Thread t2 = new Thread(runnable);
        t2.setDaemon(isDaemon);
        t2.setName("thd2");
        System.out.printf("%s is %salive and in %s state%n",
                t2.getName(),
                t2.isAlive() ? "": "not ",
                t2.getState());
        t1.start();
        t2.start();

    }

}

    