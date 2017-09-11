package interface_feature;

/**
 * Created by Sergey Zhernovoy on 20.06.2017.
 */
public interface Person extends Named {

    default String getDescription(){
        return "Person";
    };

    public static String getName(){
        return "Vasja";
    }


}
