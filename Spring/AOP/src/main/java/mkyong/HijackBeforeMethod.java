package mkyong;/**
 * @author Sergey Zhernovoy
 * create on 03.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class HijackBeforeMethod implements MethodBeforeAdvice {
    private static final Logger logger = LoggerFactory.getLogger(HijackBeforeMethod.class);

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("HijackBeforeMethod : Before method hijacked!");
    }

}

    