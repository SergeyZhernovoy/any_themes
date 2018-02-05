package stream_example;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static Integer reduceAccumulator(List<Integer> array){
        return array
                .stream()
                .reduce(0,(accumulator,element)->accumulator + element);
    }

    public static void main(String[] args) {
        System.out.print("Simple accumulator input parameter list with 1 2 3 4\t equals ");
        System.out.print(ReduceExample.reduceAccumulator(Arrays.asList(1,2,3,4)));
    }

}
