package lesson1_basic_thread_properties;/**
 * @author Sergey Zhernovoy
 * create on 07.09.2017.
 */

public class ThreadDemoSleep {

    public static void main(String[] args) {
        ThreadInner threadInner=  new ThreadInner("my thread");
        threadInner.start();

        try {
            Thread.sleep(2000);
            System.out.println("stop work ");
            threadInner.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static class ThreadInner extends Thread{

        public ThreadInner(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            try{
                int i = 0;
                while(!isInterrupted()){
                    System.out.println(i++ +") Hello , I'm "+ getName());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Bye-bye !!!");
            }
        }
    }

}

    