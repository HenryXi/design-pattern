package com.henryxi.designpattern.structural.bridge;

public class Car extends Vehicle {

    public Car(Wheel wheel) {
        super(wheel);
    }

    @Override
    void vehicleInfo() {
        System.out.println("Car with " + wheel.wheelInfo());
    }
}
