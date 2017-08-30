package part_4;/**
 * @author Sergey Zhernovoy
 * create on 30.08.2017.
 */

import interface_parts_for_all.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Saxofon implements Instrument{
    private static final Logger logger = LoggerFactory.getLogger(Saxofon.class);

    @Override
    public void play() {

    }
}

    