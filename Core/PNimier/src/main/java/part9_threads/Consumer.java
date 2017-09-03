package part9_threads;/**
 * @author Sergey Zhernovoy
 * create on 04.09.2017.
 */

public class Consumer implements Runnable {

    private Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while(true){
            String message = producer.getMessage();
            System.out.println("Got message: "+ message);
            try{
                Thread.sleep(2000);
            } catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}

    