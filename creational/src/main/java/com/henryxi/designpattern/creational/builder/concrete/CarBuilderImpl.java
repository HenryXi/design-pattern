package com.henryxi.designpattern.creational.builder.concrete;

public class CarBuilderImpl implements CarBuilder {
    Car car;

    public CarBuilderImpl() {
        this.car = new Car();
    }

    @Override
    public void setName(String name) {
        car.setName("Car");
    }

    @Override
    public void setHeight(int height) {
        car.setHeight(2);
    }

    @Override
    public void setColor(String color) {
        car.setColor("Red");
    }

    @Override
    public void setWheelNum(int wheelNum) {
        car.setWheelNum(4);
    }

    @Override
    public Car createCar() {
        return car;
    }
}
