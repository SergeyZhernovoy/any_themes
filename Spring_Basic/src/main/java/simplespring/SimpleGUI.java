package simplespring;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 14.03.2017.
 */
public class SimpleGUI {
    private final static Logger log = LoggerFactory.getLogger(SimpleGUI.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MessageRenderer messageRenderer =  applicationContext.getBean(StandartOutMessageRendererImpl.class);
        messageRenderer.rendere();
    }
}
