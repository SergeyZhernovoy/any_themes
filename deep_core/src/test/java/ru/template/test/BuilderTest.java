package ru.template.test;

import org.junit.Test;
import ru.bloch.builder.Calzone;
import ru.bloch.builder.MyPizza;
import ru.bloch.builder.Pizza;

/**
 * @author Sergey Zhernovoy
 */

public class BuilderTest {
    @Test
    public void builderTemplateTest() {
        MyPizza myPizza = new MyPizza.Builder(MyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

        System.out.println(myPizza);
        System.out.println(calzone);
    }
}
