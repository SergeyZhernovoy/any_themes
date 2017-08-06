package javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Juggler implements Performer {
    private static final Logger logger = LoggerFactory.getLogger(Juggler.class);
    private int beanBags = 3;

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public Juggler() {
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println(String.format("JUGGLING %s BEANBAGS",this.beanBags));
    }
}

    