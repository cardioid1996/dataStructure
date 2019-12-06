package com.ds.designModes.FactoryPattern;

public class CarStore {
    CarFactory carFactory;

    public CarStore(CarFactory carFactory){
        this.carFactory = carFactory;
    }

    public Car orderCar(String str){
        Car car = carFactory.createCar();
        return car;
    }
}
