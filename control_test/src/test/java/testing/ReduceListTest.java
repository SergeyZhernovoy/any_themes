package testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * @author Sergey Zhernovoy
 * create on 18.10.2017.
 */

public class ReduceListTest {

    @Test
    public void testWithOrderPart(){
        ReduceList reduceList = new ReduceList(Arrays.asList(1,2,3,4,5,5,6,5,5,5,7,7,7,8,8,9,8,8,8,0,0,0));
        reduceList.setOrder(true);
        List<Integer> test= reduceList.reduceList();
        Integer[] result = new Integer[] {1,2,3,4,6,9};
        Assert.assertThat(result[5],is(test.get(5)));
    }

    @Test
    public void testWithUnOrderPart(){
        ReduceList reduceList = new ReduceList(Arrays.asList(1,2,3,4,5,2,6,5,2,5,7,5,7,8,8,9,8,0,8,0,0,0));
        reduceList.setOrder(false);
        List<Integer> test= reduceList.reduceList();
        Integer[] result = new Integer[] {1,3,4,6,7,7,9};
        Assert.assertThat(result[4],is(test.get(4)));
    }


}

    