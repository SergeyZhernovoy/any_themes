package part9_threads;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 03.09.2017.
 */

public class Producer implements  Runnable{

    private static final int MAX_QUEUE = 5;

    private List<String> messages = new ArrayList<>();

    public synchronized String getMessage(){
        while(messages.size() == 0){
            try{
                notify();
                wait();
            } catch (InterruptedException exc){

            }
        }
        String message = (String)messages.remove(0);
        notify();
        return message;
    }


    @Override
    public void run() {
        while(true){
            putMessage();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }

    private  synchronized void putMessage() {
        while(messages.size()>=MAX_QUEUE){
            try{
                wait();
            } catch (InterruptedException exc){

            }

        }
        messages.add(new Date().toString());
        notify();
    }
}

    