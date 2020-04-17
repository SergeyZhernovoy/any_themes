package ru.bloch.no_construct;
import static ru.bloch.no_construct.Message.create;
/**
 * @author Sergey Zhernovoy
 */
public class MainApplication {

    public static void main(String[] args) {
        Message message = create();
        System.out.println(message.getTitle());
    }
}
