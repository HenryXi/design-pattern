package com.henryxi.designpattern.structural.bridge;

public class SmallWheel implements Wheel {

    @Override
    public String wheelInfo() {
        return "small wheel";
    }
}
