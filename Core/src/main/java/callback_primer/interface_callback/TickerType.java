package callback_primer.interface_callback;/**
 * @author Sergey Zhernovoy
 * create on 08.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TickerType implements TextReceiver {
    private static final Logger logger = LoggerFactory.getLogger(TickerType.class);

    @Override
    public void receiveText(String text) {
        System.out.println("TICKER:\n"+text+"\n");
    }
}

    