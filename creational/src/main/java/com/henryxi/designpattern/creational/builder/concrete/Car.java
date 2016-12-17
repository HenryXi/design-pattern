package com.henryxi.designpattern.creational.builder.concrete;

public class Car {
    private String name;
    private int height;
    private String color;
    private int wheelNum;

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", wheelNum=" + wheelNum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWheelNum() {
        return wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }
}
