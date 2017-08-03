package example1;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Sergey Zhernovoy
 * create on 21.06.2017.
 */


public class AOPTest {
    public static void main(String[] args) {
        IMessageWriter target = new MessageWriterImpl();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        IMessageWriter proxy = (MessageWriterImpl) pf.getProxy();
        target.writeMessage();
        System.out.println(" ");
        proxy.writeMessage();
    }
}

    