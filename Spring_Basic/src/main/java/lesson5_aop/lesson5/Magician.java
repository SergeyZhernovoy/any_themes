package lesson5_aop.lesson5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Sergey Zhernovoy
 * create on 18.09.2017.
 */

@Aspect
public class Magician implements MindReader {
    private String thougths;

    @Pointcut("execution(* lesson5_aop.lesson5.Thinker.thinkOfSomethings(String)) && args(thougths)")
    public void thinking(String thougths){

    }

    @Override
    @Before("thinking(thougths)")
    public void interceptThougths(String thougths) {
        System.out.println("Intercepting volunteer's thougths");
        this.thougths = thougths;

    }

    @Override
    public String getThougths() {
        return this.thougths;
    }
}

    