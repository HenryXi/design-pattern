package com.henryxi.designpattern.creational.builder.unconcrete;

public class Client {
    public static void main(String[] args) {
        Car car =  new Car.CarBuilder()
                .withName("Car")
                .withHeight(1)
                .withWheelNum(4)
                .withColor("Red").build();
        System.out.println(car);
    }
}
