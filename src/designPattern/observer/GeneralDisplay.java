package designPattern.observer;


/**
 * Created by wybe on 7/22/16.
 */
public class GeneralDisplay implements Observer {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public GeneralDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    public void display() {
        System.out.println(temperature);
        System.out.println(humidity);
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

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }
}
