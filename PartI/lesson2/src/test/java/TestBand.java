/**
 * Created by Sergey on 04.05.2017.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.Filter;
import ru.FilterField;
import ru.Operation;
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

    @Test
    public void anyTest(){
        List<Filter> filters = new ArrayList<>();
        Filter one = new FilterField("mo.state_date", Operation.EQ,1);
        Filter two = new FilterField("mo.state_date", Operation.GT,2);
        Filter three = new FilterField("1mo.state_date", Operation.LT,3);
        filters.add(one);
        filters.add(two);
        filters.add(three);
        HashMap<String, String> stateDateFilterMap = new HashMap<>();
        stateDateFilterMap.put("EQ", " and trunc(mo.state_date, 'mi') = trunc(?, 'mi')");
        stateDateFilterMap.put("NE", " and trunc(mo.state_date, 'mi') <> trunc(?, 'mi')");
        stateDateFilterMap.put("GT", " and trunc(mo.state_date, 'mi') > trunc(?, 'mi')");
        stateDateFilterMap.put("GE", " and trunc(mo.state_date, 'mi') >= trunc(?, 'mi')");
        stateDateFilterMap.put("LT", " and trunc(mo.state_date, 'mi') < trunc(?, 'mi')");
        stateDateFilterMap.put("LE", " and trunc(mo.state_date, 'mi') <= trunc(?, 'mi')");

        String sql = "select mo.* from measure_object_prop_v mo" +
                " where ( ? is null" +
                " or exists (select 0 " +
                " from device_transfer_hist_v his " +
                " where sysdate between his.start_date and nvl(his.end_date, sysdate) " +
                " and his.measure_object_id = mo.measure_object_id " +
                " and (upper(his.serial_number) like upper(?) or his.device_transfer_id = ?)" +
                ")) and " +
                " (? is null or mo.measure_object_id = ?) and " +
                "(? is null or exists (select 0 " +
                "from measure_object_consumer_v moc " +
                "where moc.measure_object_id = mo.measure_object_id " +
                "and moc.consumer_id = ? " +
                "))";

        final boolean[] stateDateFilter = {false};
        List<Integer> stateDates = new ArrayList<>();

        StringBuilder sqlQuery = new StringBuilder(sql);
        System.out.println(filters);
        List<Filter> copyfilters = new ArrayList<>(filters);
        filters.stream()
                .filter(filter -> filter instanceof FilterField)
                .filter(filter -> "mo.state_date".equals(((FilterField) filter).getFieldName()))
                .forEach(filter -> {if(stateDateFilterMap.get(((FilterField) filter).getOperation().toString())!= null) {
                            stateDateFilter[0] = true;
                            stateDates.add( (Integer) ((FilterField) filter).getValue() );
                            sqlQuery.append(stateDateFilterMap.get(((FilterField) filter).getOperation().toString()));
                            copyfilters.remove(filter);
                        } }
                );
       System.out.println(stateDates);
       System.out.println(sqlQuery);
        System.out.println(copyfilters);



//
//        List<Filter> copyFilters = new ArrayList<>(filters);
//        List<Integer> stateDates2 = new ArrayList<>();
//        for(Iterator<Filter> getFilter = copyFilters.iterator(); getFilter.hasNext(); ) {
//            Filter filter = getFilter.next();
//
//            if (filter instanceof FilterField) {
//                if( "mo.state_date".equals(((FilterField) filter).getFieldName()) ) {
//                    for (Map.Entry<String, String> entry : stateDateFilterMap.entrySet()) {
//                        if( entry.getKey().equals( (((FilterField) filter).getOperation().toString()) ) ) {
//                            stateDateFilter[0] = true;
//
//                            stateDates2.add( (Integer) ((FilterField) filter).getValue() );
//
//                            sql += entry.getValue();
//                        }
//                    }
//
//                    getFilter.remove();
//                }
//            }
//        }
//        System.out.println("///////////////////////////////////////////////////////");
//
//        System.out.println(stateDates2);
//        System.out.println(sql);

    }





}
