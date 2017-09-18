package lesson5_aspect_obj_programs.lesson1;

import interface_parts_for_all.PerformanceException;
import interface_parts_for_all.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sergey Zhernovoy
 * create on 18.09.2017.
 */

public class Kloun implements Performer
{
    @Override
    public void perform() throws PerformanceException {
        System.out.println("I'm cloun. Clap me...");
    }

    public static void main(String[] args) throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_aop_lesson1.xml");
        Performer cloun = (Performer) ctx.getBean("cloun");
        cloun.perform();
    }

}

    