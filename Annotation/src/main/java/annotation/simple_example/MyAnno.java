package annotation.simple_example;

/**
 * @author Sergey Zhernovoy
 *         create on 04.07.2017.
 */
public @interface MyAnno {
    String str() default "Test";
    int val() default 1;
}
