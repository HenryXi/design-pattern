package com.henryxi.designpattern.creational.builder.concrete;

public class CarBuildDirector {
    private CarBuilder builder;

    public CarBuildDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car construct() {
        builder.setWheelNum(4);
        builder.setColor("Red");
        builder.setName("Car");
        builder.setHeight(1);
        return builder.createCar();
    }

    public static void main(String[] args) {
        CarBuilder builder = new CarBuilderImpl();
        CarBuildDirector carBuildDirector = new CarBuildDirector(builder);
        System.out.println(carBuildDirector.construct());
    }
}
