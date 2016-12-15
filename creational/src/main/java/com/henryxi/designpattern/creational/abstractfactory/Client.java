package com.henryxi.designpattern.creational.abstractfactory;

public abstract class Client implements AbstractFactory {
    public static void main(String[] args) throws Exception {
        String config = "1"; // you can get the value of config by reading config file
//        String config = "2";
        AbstractFactory factory;
        switch (config) {
            case "1":
                factory = new ConcreteFactory1();
                break;
            case "2":
                factory = new ConcreteFactory2();
                break;
            default:
                throw new Exception("config error");
        }
        // start your business logic code
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        System.out.println("Product A : " + productA.getProductAName());
        System.out.println("Product B : " + productB.getProductBName());
    }
}
