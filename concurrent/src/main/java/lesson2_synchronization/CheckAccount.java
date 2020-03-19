package lesson2_synchronization;/**
 * @author Sergey Zhernovoy
 * create on 24.09.2017.
 */

public class CheckAccount {
    private volatile int balance;
    public CheckAccount(int balance){
        this.balance = balance;
    }

    public synchronized boolean isWithdrow(int amount){

        boolean result = false;

        if(amount <= balance){
            try{
                Thread.sleep((int)Math.random()*200);
            } catch (InterruptedException exc){

            }
            System.out.println("current balance = "+ balance);
            balance -= amount;
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
        final CheckAccount checkAccount = new CheckAccount(1000);
        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();
            for(int i = 0; i < 100; i++){
                System.out.println(name + " withdrow 10$: " + checkAccount.isWithdrow(10));
            }
        };

        Thread thdHus = new Thread(runnable,"Husband");
        Thread thdWife = new Thread(runnable,"Wife");
        thdWife.start();
        thdHus.start();

    }



}

    