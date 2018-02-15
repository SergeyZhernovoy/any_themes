package pattern_observer;

public class CurrentConditionsDisplay extends AbstractMeasurementDevice implements Observer, Display {


    @Override
    public void update(Integer temperature, Integer pressure, Integer humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    @Override
    public Integer getTemperature() {
        return this.temperature;
    }
}
