/**
 * Created by Sergey on 04.05.2017.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.band.Musician;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;

public class TestBand {
    private static final Logger logger = LoggerFactory.getLogger(TestBand.class);


    private List<String> testArray = new ArrayList<>();

    @Before
    public void fillArray(){
        for(int index = 0; index < 100000; index++){
            testArray.add(Integer.valueOf(index).toString());
        }
    }


    @Test
    public void testStream(){
        List<Musician> artists = Arrays.asList( new Musician("First","London"), new Musician("second","Moscow"));
        long count = artists.stream().filter(artist -> artist.isFrom("Moscow")).count();
        Assert.assertThat(count, is(1L));
    }

    @Test(timeout = 10000)
    public void testTrivialCopy(){

        List<String> copy = new ArrayList<>();
        for (String str : testArray){
            copy.add(str.toUpperCase());
        }
    }

    @Test(timeout = 10000)
    public void testStreamCopy(){
        List<String> copy = testArray.stream().map(string->string.toUpperCase()).collect(Collectors.toList());
    }
 }
