package knigths_1;/**
 * @author Sergey Zhernovoy
 * create on 02.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(QuestException.class);

    public QuestException(String message){
        super(message);
    }
}

    