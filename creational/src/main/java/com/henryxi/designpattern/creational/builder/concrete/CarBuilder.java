package com.henryxi.designpattern.creational.builder.concrete;

public interface CarBuilder {
    void setName(String name);

    void setHeight(int height);

    void setColor(String color);

    void setWheelNum(int wheelNum);

    Car createCar();
}
