package testing;

import java.util.*;
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

    public void setOrder(Boolean order){
        this.order = order;
    }

    public List<Integer> reduceList(){

        Map<Integer,Integer> repeat = new HashMap<>();
        List<Integer> reduce = new ArrayList<>();

        this.array
                .stream()
                .forEach(x->{
                    reduce.add(x);
                    if(order && reduce.size() >= 3 ){
                        if(!repeat.containsKey(x)){
                            if( x == reduce.get(reduce.size()-1) && x == reduce.get(reduce.size()-2) && x == reduce.get(reduce.size()-3)){
                                repeat.put(x,1);
                            }
                        }
                    }
                    else {
                        if(repeat.containsKey(x)){
                            repeat.replace(x,repeat.get(x)+1);
                        } else {
                            repeat.put(x,1);
                        }
                    }

                });
        return  reduce
                .stream()
                .filter(x-> {
                    if(order){
                        return !repeat.containsKey(x);
                    } else {
                        int value = repeat.get(x) == null ? 0 : repeat.get(x) ;
                        return  value  < 3;
                    }
                })
                .collect(Collectors.toList());
    }


}

    