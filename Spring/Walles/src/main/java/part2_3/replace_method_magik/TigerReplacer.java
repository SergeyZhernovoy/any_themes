package part2_3.replace_method_magik;/**
 * @author Sergey Zhernovoy
 * create on 29.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class TigerReplacer implements MethodReplacer {
    private static final Logger logger = LoggerFactory.getLogger(TigerReplacer.class);

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return "A ferioucious tiger";
    }
}

    