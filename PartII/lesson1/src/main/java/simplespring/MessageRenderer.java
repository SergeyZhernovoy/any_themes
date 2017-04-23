package simplespring;

/**
 * Created by admin on 14.03.2017.
 */
public interface MessageRenderer {
    void rendere();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
