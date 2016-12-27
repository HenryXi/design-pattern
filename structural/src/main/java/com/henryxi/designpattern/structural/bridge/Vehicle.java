package com.henryxi.designpattern.structural.bridge;

public abstract class Vehicle {
    protected Wheel wheel;

    public Vehicle(Wheel wheel) {
        this.wheel = wheel;
    }

    abstract void vehicleInfo();
}
