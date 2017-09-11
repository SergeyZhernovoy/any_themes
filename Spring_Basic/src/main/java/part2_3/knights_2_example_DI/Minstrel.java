package part2_3.knights_2_example_DI;/**
 * @author Sergey Zhernovoy
 * create on 03.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minstrel {
    private static final Logger logger = LoggerFactory.getLogger(Minstrel.class);
    public void singBeforeQuest(){
        System.out.println("la la la : knight go to make quest");
    }

    public void singAfterQuest(){
        System.out.println("tu du du: knight done quest and do embark");
    }

}

    