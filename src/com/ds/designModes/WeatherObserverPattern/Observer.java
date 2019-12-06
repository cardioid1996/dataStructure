package com.ds.designModes.WeatherObserverPattern;

public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
