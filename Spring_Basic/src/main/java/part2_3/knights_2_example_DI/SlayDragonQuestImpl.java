package part2_3.knights_2_example_DI;/**
 * @author Sergey Zhernovoy
 * create on 02.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlayDragonQuestImpl implements Quest {
    private static final Logger logger = LoggerFactory.getLogger(SlayDragonQuestImpl.class);

    @Override
    public void embark() {
        System.out.println("I kill Dragon !");
    }
}

    