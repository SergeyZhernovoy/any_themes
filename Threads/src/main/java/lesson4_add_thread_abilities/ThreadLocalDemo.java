package lesson4_add_thread_abilities;/**
 * @author Sergey Zhernovoy
 * create on 31.10.2017.
 */

/**
 * https://dzone.com/articles/painless-introduction-javas-threadlocal-storage
 */
public class ThreadLocalDemo {

    private static volatile ThreadLocal<String> userID = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();
            if(name.equals("A")){
                userID.set("foxtrot");
            } else {
                userID.set("charlie");
            }

            System.out.println(name + " "+ userID.get());
        };

        Thread thdA = new Thread(runnable,"A");
        Thread thdB = new Thread(runnable,"B");
        thdA.start();
        thdB.start();


    }

}

    