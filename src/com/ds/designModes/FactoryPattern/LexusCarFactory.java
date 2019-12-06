package com.ds.designModes.FactoryPattern;

public class LexusCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Lexus();
    }
}
