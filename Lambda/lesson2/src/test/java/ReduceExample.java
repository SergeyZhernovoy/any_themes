import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Created by Sergey on 08.05.2017.
 */


public class ReduceExample {

    private int [] arrayInt = {1,2,3,4,5,6};

    @Test
    public void testReduce(){
        int summary = Arrays.stream(arrayInt).reduce(0,(acc, element) -> (acc+element));
        System.out.println(summary);
    }

}
