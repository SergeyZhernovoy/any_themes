package pattern_observer;

public class StartUI {
    public static void main(String[] args) {
        WeatherDate weatherDate = new WeatherDate();
        CurrentConditionsDisplay observer = new CurrentConditionsDisplay();
        weatherDate.registerObserver(observer);
        weatherDate.setMeasurementChanged(10,11,12);
        observer.display();
    }
}
