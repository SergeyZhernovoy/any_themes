package rigth_clone;/**
 * @author Sergey Zhernovoy
 * create on 01.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class DeepSheep implements Cloneable {
    private static final Logger logger = LoggerFactory.getLogger(DeepSheep.class);
    private HashMap<String,String> flock = new HashMap<>();

    @Override
    protected DeepSheep clone()  {
        try{
            DeepSheep copy = (DeepSheep) super.clone();
            copy.flock = (HashMap)flock.clone();
            return copy;
        } catch (CloneNotSupportedException exc){
            throw  new Error("This is uncredible");
        }
    }

    public void setValue(String key, String value){
        this.flock.put(key,value);
    }

    public String getValue(String key){
        return this.flock.get(key);
    }

    public static void main(String[] args) {
        DeepSheep one = new DeepSheep();
        one.setValue("one","one");
        one.setValue("two","one");
        DeepSheep two = one.clone();
        one.setValue("one","one next");
        System.out.println(two.getValue("one"));
    }

}

    