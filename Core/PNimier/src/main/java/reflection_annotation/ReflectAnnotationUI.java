package reflection_annotation;/**
 * @author Sergey Zhernovoy
 * create on 16.08.2017.
 */


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class ReflectAnnotationUI {

    public static void main(String[] args) throws IllegalAccessException {

            IPerson sergey = new Developer();
            IPerson diman = new Student();

            IPerson devProxy = (IPerson) Proxy.newProxyInstance(Developer.class.getClassLoader(),Developer.class.getInterfaces(), new CheckAccess(sergey));

            IPerson studentProxy = (IPerson) Proxy.newProxyInstance(Student.class.getClassLoader(),Student.class.getInterfaces(), new CheckAccess(diman));

            System.out.println("This is Sergey");
            System.out.println("Sergey say your name - " + devProxy.getName());

            System.out.println("This is Diman");
            System.out.println("Diman say your name - " + studentProxy.getName());

    }

    public void print(Object o,Class c ) throws IllegalAccessException {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations){
                if(annotation.annotationType().equals(Access.class)){
                    System.out.println(field.get(o));
                }
            }
        }
    }

}

    