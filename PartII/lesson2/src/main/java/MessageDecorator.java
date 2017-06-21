/**
 * @author Sergey Zhernovoy
 * create on 21.06.2017.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDecorator implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MessageDecorator.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello ");
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}

    