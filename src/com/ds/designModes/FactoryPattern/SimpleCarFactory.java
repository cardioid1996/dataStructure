package com.ds.designModes.FactoryPattern;

public class SimpleCarFactory{
    public SimpleCarFactory(){ }

    public static Car createCar(String str){
        Car car = null;
        if (str == "BMW")
            car = new BMW();
        if (str == "Lexus")
            car = new Lexus();
        return car;
    }
}
