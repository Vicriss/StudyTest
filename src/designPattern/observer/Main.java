package designPattern.observer;

/**
 * Created by wybe on 7/22/16.
 */
public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        GeneralDisplay generalDisplay = new GeneralDisplay(weatherData);

        weatherData.setMeasurements(1, 2, 3);
        weatherData.setMeasurements(2, 2, 3);
        weatherData.setMeasurements(4, 2, 3);
    }
}
