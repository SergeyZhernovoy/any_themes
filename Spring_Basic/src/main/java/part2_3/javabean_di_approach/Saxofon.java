package part2_3.javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import interface_parts_for_all.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Saxofon implements Instrument {
    private static final Logger logger = LoggerFactory.getLogger(Saxofon.class);

    @Override
    public void play() {
        System.out.println("I play on saxofon");
    }
}

    