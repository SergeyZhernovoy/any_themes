package lesson1_basic_thread_properties;/**
 * @author Sergey Zhernovoy
 * create on 31.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Animation implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Animation.class);
    private boolean animate = true;
    private Thread myTread;
    private String message;

    public Animation(String message) {
        this.message = message;
        myTread = new Thread(this);
        myTread.start();
    }

    @Override
    public void run() {
        int index = 0;
        while(animate){
            if(index < 100){
                index++;
            } else {
                animate = !animate;
            }
            System.out.println("My message :" +this.message+" Step " + index + " in Thread "+ Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        Animation happy = new Animation("Sergey");
    }

}

    