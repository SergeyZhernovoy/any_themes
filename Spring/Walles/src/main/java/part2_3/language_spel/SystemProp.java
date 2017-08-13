package part2_3.language_spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * @author Sergey Zhernovoy
 * create on 13.08.2017.
 */

public class SystemProp {
    private Properties prop;

    public void printProperties(){
        for(String key : prop.stringPropertyNames())
        System.out.println("print property:"+ key +"[" + prop.getProperty(key)+"]");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spel.xml");
        SystemProp prop = (SystemProp) ctx.getBean(SystemProp.class);
        prop.printProperties();
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}

    