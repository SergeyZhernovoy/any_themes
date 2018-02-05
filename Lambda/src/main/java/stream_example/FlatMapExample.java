package stream_example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Объект flatMap позволяет заменить значение  объектом Stream  и конкатенировать потоки
 */
public class FlatMapExample {
    public static List<Integer> concatArray(List<Integer> array1, List<Integer> array2){
        return Stream
                .of(array1,array2)
                .flatMap(number->number.stream())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> out = FlatMapExample.concatArray(Arrays.asList(1,2,3),Arrays.asList(4,6,5));
        out.forEach(element->{
            System.out.println(element);
        });
    }
}
