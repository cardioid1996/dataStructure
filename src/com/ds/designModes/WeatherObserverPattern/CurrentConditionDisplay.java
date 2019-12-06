package com.ds.designModes.WeatherObserverPattern;

import java.util.Observer;
import java.util.Observable;

public class CurrentConditionDisplay implements DisplayElement, Observer {
    private float temprature;
    private float humidity;
    private float pressure;
    private Observable weatherData;

    public CurrentConditionDisplay(){
        // pass
    }

    public CurrentConditionDisplay(Observable weatherData){
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }


    public void update(Observable o, Object arg){
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temprature = weatherData.getTemprature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    public void display(){
        System.out.println("temperature:" + temprature);
        System.out.println("humidity:" + humidity);
        System.out.println("pressure:" + pressure);

    }

}
