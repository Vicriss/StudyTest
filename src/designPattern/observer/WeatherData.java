package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wybe on 7/22/16.
 */
public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Observer> observers = new ArrayList<>();

    public void measureChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void register(Observer obj) {
        if (obj != null)
            this.observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int index = observers.indexOf(obj);
        if (index >= 0)
            observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
