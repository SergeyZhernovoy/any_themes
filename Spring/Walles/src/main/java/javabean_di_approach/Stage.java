package javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stage {
    private static final Logger logger = LoggerFactory.getLogger(Stage.class);
    private Stage(){
    }

    private static class StageHolder{
        static Stage instance = new Stage();
    }

    public static Stage getInstance(){
        return StageHolder.instance;
    }

    public void turnOnLight(){
        System.out.println("Turn on light");
    }

    public void turnOffLight(){
        System.out.println("Turn off light");
    }

}

    