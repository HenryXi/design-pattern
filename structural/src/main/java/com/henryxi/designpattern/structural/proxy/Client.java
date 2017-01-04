package com.henryxi.designpattern.structural.proxy;

public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        System.out.println("result: " + proxy.calculate(1, 2));
    }
}
