/**
 * Created by Sergey on 04.05.2017.
 */

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.band.Album;
import ru.band.Musician;

import java.util.Arrays;
import java.util.List;

public class TestBand {
    private static final Logger logger = LoggerFactory.getLogger(TestBand.class);

    @Test
    public void testStream(){
        List<Musician> artists = Arrays.asList( new Musician("First","London"), new Musician("second","Moscow"));
        long count = artists.stream().filter(artist -> artist.isFrom("Moscow")).count();
        System.out.println(count);
    }

}
