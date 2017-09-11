package guides_AOP.example1; /**
 * @author Sergey Zhernovoy
 * create on 21.06.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageWriterImpl implements IMessageWriter {
    private static final Logger logger = LoggerFactory.getLogger(MessageWriterImpl.class);

    @Override
    public void writeMessage() {
        System.out.print("World");
    }
}

    