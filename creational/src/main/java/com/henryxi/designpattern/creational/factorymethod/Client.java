package com.henryxi.designpattern.creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryB();
        System.out.println(factory.showProductName());
    }
}
