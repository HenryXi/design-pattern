package com.henryxi.designpattern.structural.proxy;


public class Proxy implements Calculator {

    private RealObject realObject = null;

    public int calculate(int a, int b) {
        if (realObject == null) {
            realObject = new RealObject();
        }
        return realObject.calculate(a, b);
    }
}
