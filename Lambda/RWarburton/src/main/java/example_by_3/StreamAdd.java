package example_by_3;/**
 * @author Sergey Zhernovoy
 * create on 09.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class StreamAdd {
    private static final Logger logger = LoggerFactory.getLogger(StreamAdd.class);
    private int result=0;

    public int addUpp(Stream<Integer> numeric){
        this.result = Stream
                        .concat(numeric,Stream.of(result))
                        .reduce(0,(acc,elem)->(acc+elem));
        return this.result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static void main(String[] args) {
        StreamAdd streamAdd = new StreamAdd();
        System.out.println("result = "+ streamAdd.getResult());
        streamAdd.addUpp(Stream.of(1));
        System.out.println("result = "+ streamAdd.getResult());
        streamAdd.addUpp(Stream.of(5));
        System.out.println("result = "+ streamAdd.getResult());
        streamAdd.addUpp(Stream.of(4));
        System.out.println("result = "+ streamAdd.getResult());
    }

}

    