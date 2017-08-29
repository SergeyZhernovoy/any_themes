package part2_3.javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUI {
    private static final Logger logger = LoggerFactory.getLogger(SpringUI.class);

    public static void main(String[] args) throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("javabean_di_approach.xml");
        Performer musician = (Performer) ctx.getBean("carl");

        //Performer first = (Performer) ctx.getBean("singleton");
        System.out.println("Now show musican -  CARL");
        musician.perform();

        System.out.println("Now show vocal - STEVE");
        musician = (Performer) ctx.getBean("steve");
        musician.perform();
        System.out.println("Now show musican - MARK");
        musician = (Performer) ctx.getBean("mark");
        musician.perform();


    }
}

    