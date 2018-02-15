package pattern_observer;


public interface Display extends GetDate {
    default void display(){
        System.out.println("Temparature: " + getTemperature());
    }
}
