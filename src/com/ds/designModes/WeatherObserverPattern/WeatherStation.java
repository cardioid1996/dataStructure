package com.ds.designModes.WeatherObserverPattern;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay display = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(30, 65,34.5f);

        weatherData.setMeasurements(20, 65,35.5f);
    }
}
