package lesson5_aop.lesson1;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Sergey Zhernovoy
 * create on 18.09.2017.
 */

public class Audience {

    public void takeSeats(){
        System.out.println("The audience is taking their seats");
    }

    public void turnOffCellPhones(){
        System.out.println("The audience is turning off their cellphones");
    }

    public void applaud(){
        System.out.println("CLAP CLAP CLAP CLAP CLAP CLAP");
    }

    public void demandRefund(){
        System.out.println("Boo ! We want our money back");
    }

    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint){
            try{
                System.out.println("The audience is taking their seats");
                System.out.println("The audience os turning off their cellphones");
                long start = System.currentTimeMillis();
                proceedingJoinPoint.proceed();
                long end = System.currentTimeMillis();
                System.out.println("CLAP CLAP CLAP CLAP CLAP CLAP");
                System.out.println("The performance took is " + (end - start)+ " millisecund");
            } catch (Throwable throwable){
                System.out.println("Boo! We want our money back");
            }
    }

}

    