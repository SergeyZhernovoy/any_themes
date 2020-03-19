package lesson2_synchronization;/**
 * @author Sergey Zhernovoy
 * create on 04.11.2017.
 */

public class Caller implements Runnable {

    private String msg;
    private CallMsg target;
    private Thread thread;

    public Caller(String msg, CallMsg target) {
        this.msg = msg;
        this.target = target;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        this.target.call(msg);
    }

    public static void main(String[] args) {
        CallMsg callMsg = new CallMsg();
        Caller caller1 = new Caller("Добро пожаловать",callMsg);
        Caller caller2 = new Caller("в синхронизированный",callMsg);
        Caller caller3 = new Caller("мир!",callMsg);
        try {
            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

    