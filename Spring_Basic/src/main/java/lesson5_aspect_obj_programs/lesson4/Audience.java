package lesson5_aspect_obj_programs.lesson4;

import org.aspectj.lang.annotation.*;

/**
 * @author Sergey Zhernovoy
 * create on 18.09.2017.
 */

@Aspect
public class Audience {

    @Pointcut("execution(* interface_parts_for_all.Performer.perform(..))")
    public void performance(){

    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("The audience is taking their seats");
    }

    @Before("performance()")
    public void turnOffCellPhones(){
        System.out.println("The audience is turning off their cellphones");
    }

    @AfterReturning("performance()")
    public void applaud(){
        System.out.println("CLAP CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Boo ! We want our money back");
    }

}

    