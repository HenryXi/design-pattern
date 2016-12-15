package com.henryxi.designpattern.creational.factorymethod;

public class ConcreteFactoryA extends Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
