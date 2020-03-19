package optional_example;

import java.util.Optional;

public class OptionalInAction {
    static String example;

    public static String getStaticField(){
        return Optional
                .ofNullable(example)
                .orElse("Static field is empty");
    }

    public static String getStaticFieldWithOrElseGet(){
        return Optional
                .ofNullable(example)
                .orElseGet(()->"Static field is empty");
    }


    public static void main(String[] args) {
        System.out.println("@Before change static field");
        System.out.println(OptionalInAction.getStaticFieldWithOrElseGet());
        System.out.println("@After change static field");
        OptionalInAction.example = "Static field get new State";
        System.out.println(OptionalInAction.getStaticFieldWithOrElseGet());
    }
}
