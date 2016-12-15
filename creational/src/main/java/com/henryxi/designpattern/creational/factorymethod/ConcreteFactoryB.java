package com.henryxi.designpattern.creational.factorymethod;

public class ConcreteFactoryB extends Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
