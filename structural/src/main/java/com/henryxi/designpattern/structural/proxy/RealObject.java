package com.henryxi.designpattern.structural.proxy;

public class RealObject implements Calculator {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
