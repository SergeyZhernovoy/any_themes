package pattern_observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherDate implements Subject {
    /** температура */
    private Integer temperature;
    /** давление */
    private Integer pressure;
    /** влажность */
    private Integer humidity;

    private Boolean stateChange = false;

    public void setChanged() {
        this.stateChange = true;
    }

    private List<Observer> observers;

    public WeatherDate() {
        this.observers = new ArrayList<>();
    }


    public void setMeasurementChanged(Integer temperature, Integer pressure, Integer humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(this.observers.contains(observer)) {
            this.observers.removeIf(item-> item.equals(observer));
        }
    }

    @Override
    public void notifyObservers() {

        if (stateChange) {
            this
                    .observers
                    .stream()
                    .peek(item->item.update(temperature,pressure,humidity))
                    .collect(Collectors.toList());
        }

        stateChange = false;

    }
}
