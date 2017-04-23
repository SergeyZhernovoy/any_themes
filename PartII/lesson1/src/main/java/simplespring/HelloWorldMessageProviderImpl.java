package simplespring;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 14.03.2017.
 */
@Service("messageProvider")
public class HelloWorldMessageProviderImpl implements MessageProvider {
    private final static Logger log = LoggerFactory.getLogger(HelloWorldMessageProviderImpl.class);
    private String message;

    @Autowired
    public HelloWorldMessageProviderImpl(final String message){
        this.message = message;
    }

    public HelloWorldMessageProviderImpl() {
    }

    @Override
    public String getMessage() {
        if(this.message != null){
            return  this.message;
        }
        return "Hello, world !!!";
    }
}
