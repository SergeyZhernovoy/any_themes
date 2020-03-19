package lesson2_synchronization;/**
 * @author Sergey Zhernovoy
 * create on 04.11.2017.
 */

public class CallMsg {
    public synchronized void call(String msg){
        System.out.print("["+msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

    