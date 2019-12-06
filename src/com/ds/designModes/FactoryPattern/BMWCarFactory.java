package com.ds.designModes.FactoryPattern;

public class BMWCarFactory implements CarFactory{
    @Override
    public Car createCar(){
        return new BMW();
    }

}
