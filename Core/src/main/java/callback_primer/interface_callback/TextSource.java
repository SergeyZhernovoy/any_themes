package callback_primer.interface_callback;/**
 * @author Sergey Zhernovoy
 * create on 08.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextSource {
    private static final Logger logger = LoggerFactory.getLogger(TextSource.class);
    TextReceiver receiver;
    public TextSource(TextReceiver receiver){
        this.receiver = receiver;
    }

    public void sendText(String s){
        receiver.receiveText(s);
    }

    public static void main(String[] args) {
        TextReceiver receiver = new TickerType();
        TextSource source = new TextSource(receiver);
        source.sendText("Hello world !!!");
    }

}

    