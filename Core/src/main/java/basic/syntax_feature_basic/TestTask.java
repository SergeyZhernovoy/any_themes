package basic.syntax_feature_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Zhernovoy
 * create on 07.09.2017.
 */

public class TestTask {

    public static void main(String[] args) {
        Map<String,Object> input = new HashMap();
        input.put("1 2",new Object());
        input.put("2 1",new Object());
        input.put("3 4",new Object());
        input.put("5 6",new Object());
        input.put("6 5",new Object());

        List<String> result = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();

        for(String current : input.keySet()){
            String keyLeft = current.substring(0,1);
            String keyRight = current.substring(2);
            String next = keyRight+" "+keyLeft;
            if(input.get(next) != null){
                if(res.get(current) == null){
                    res.put(next,new Object());
                    StringBuilder nextString;
                    nextString = new StringBuilder();
                    nextString.append(keyLeft);
                    nextString.append("\t");
                    nextString.append(keyRight);
                    nextString.append("\t");
                    nextString.append(keyLeft);
                    result.add(nextString.toString());
                }
            }
        }

        for (String textResult : result) {
            System.out.println(textResult);
        }
    }

}

    