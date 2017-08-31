package part7_reflection_proxy_annotation;/**
 * @author Sergey Zhernovoy
 * create on 16.08.2017.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CheckAccess implements InvocationHandler {

    Object target;

    public CheckAccess(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        boolean result = true;
        Class c = target.getClass();

        Access access = (Access) c.getAnnotation(Access.class);
        if(target!=null && access != null){
            result = access.value();
        }

        if(!result){
            System.out.println("Access denied...");
            return null;
        } else {
            System.out.println("Access is allowed...");
            return method.invoke(target,args);
        }

    }
}

    