package part2_3.replace_method_magik;/**
 * @author Sergey Zhernovoy
 * create on 29.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import interface_parts_for_all.PerformanceException;
import interface_parts_for_all.Performer;

public class SpringUI {
    private static final Logger logger = LoggerFactory.getLogger(SpringUI.class);

    public static void main(String[] args) throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_3_part.xml");
        Performer magician = (Performer) ctx.getBean("harry");
        magician.perform();
    }
}

    