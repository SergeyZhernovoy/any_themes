package simplespring;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 14.03.2017.
 */
@Service("messageRenderer")
public class StandartOutMessageRendererImpl implements MessageRenderer {
    private final static Logger log = LoggerFactory.getLogger(StandartOutMessageRendererImpl.class);
    private MessageProvider messageProvider;
    @Override
    public void rendere() {
        if(messageProvider == null){
            throw new RuntimeException("You must set messageProvider of class:"+ StandartOutMessageRendererImpl.class.getName());
        }

        System.out.println(messageProvider.getMessage());

    }


    @Override
    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return null;
    }
}
