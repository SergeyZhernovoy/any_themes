import lesson3.Entity;
import lesson3.ReflectionAnalizator;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by Sergey Zhernovoy on 17.06.2017.
 */
public class ReflectionAnalizatorTest {
    @Test
    public void analizeFieldAnyClass() throws Exception {
        Entity entity = new Entity.Builder()
                .setIdEntity(1L)
                .setDescriptionEntity("Test").build();

        LocalDate date = LocalDate.now();

        ReflectionAnalizator<Entity> reflectionAnalizator = new ReflectionAnalizator<>(entity.getClass(),entity);
        reflectionAnalizator.printFields();
        reflectionAnalizator = new ReflectionAnalizator<>(date.getClass(),date);
        reflectionAnalizator.printFields();


//        Person person = new Person();
//        ReflectionAnalizator<Person> reflectionAnalizator = new ReflectionAnalizator<>(person.getClass(),person);
//        reflectionAnalizator.printFields();


    }

}