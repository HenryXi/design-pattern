package com.henryxi.designpattern.structural.bridge;

public class Client {
    public static void main(String[] args) {
        Car bigCar = new Car(new BigWheel());
        bigCar.vehicleInfo();
        Car smallCar = new Car(new SmallWheel());
        smallCar.vehicleInfo();
        Car manyWheelCar = new Car(new AGroupWheel());
        manyWheelCar.vehicleInfo();
    }
}
