package java_threads_and_the_concurrency_utils.chapter1;/**
 * @author Sergey Zhernovoy
 * create on 05.09.2017.
 */

public class ThreadDemoInterrupt {

    public static void main(String[] args) {
        Runnable runnable = () -> {
          String name = Thread.currentThread().getName();
          int count = 0;
          while (!Thread.interrupted()){
              System.out.println(name + " "+ count++);
          }
        };

        Thread thdA = new Thread(runnable);
        Thread thdB = new Thread(runnable);
        thdA.start();
        thdB.start();
        while(true){
            double n = Math.random();
            if(n >= 0.49999999 && n <= 0.500000001){
                break;
            }
        }
        thdA.interrupt();
        thdB.interrupt();




    }
}

    