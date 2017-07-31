package calc;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 07.03.2017.
 */
public class StreamTest {

    private List<String> artists;

    public StreamTest(){
            artists = Stream.of("first","second")
                    .collect(Collectors.toList());
    }

    public void print(){
        for(String string : artists)
        System.out.println(string);
    }

    public static void main(String[] args) {
        new StreamTest().print();
    }


}
