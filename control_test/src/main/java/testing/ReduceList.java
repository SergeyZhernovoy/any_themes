package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Zhernovoy
 * create on 18.10.2017.
 */

public class ReduceList {

    private List<Integer> array;
    private Boolean order = false;


    public ReduceList(List<Integer> array){
        this.array = array;
    }

    public ReduceList(){
        this.array = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,5,6,6,6));
    }

    public List<Integer> reduceList(){

        List<Integer> repeat = new ArrayList<>();
        List<Integer> reduce = new ArrayList<>();

        this.array
                .stream()
                .forEach(x->{
                    if(!repeat.contains(x))
                        reduce.add(x);
                  if(order && reduce.size() > 3){
                       if(x == reduce.get(reduce.size()-1) && x == reduce.get(reduce.size()-2) && x == reduce.get(reduce.size()-3)){
                          repeat.add(x);
                      }
                  }
                });

        return  reduce
                .stream()
                .filter(x-> !repeat.contains(x)).collect(Collectors.toList());

    }


}

    