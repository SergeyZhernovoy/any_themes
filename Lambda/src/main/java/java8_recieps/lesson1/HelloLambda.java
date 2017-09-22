package java8_recieps.lesson1;/**
 * @author Sergey Zhernovoy
 * create on 22.09.2017.
 */

public class HelloLambda {

    public interface HelloType{
        void hello(String text);
    }

    public static void main(String[] args) {
        HelloType helloType= text -> {System.out.println("Hello " + text);};
        helloType.hello("Sergey");

    }

}

    