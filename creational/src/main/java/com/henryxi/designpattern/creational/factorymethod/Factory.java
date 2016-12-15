package com.henryxi.designpattern.creational.factorymethod;

public abstract class Factory {
    public String showProductName() {
        Product product = createProduct();
        return product.getProductName();
    }

    abstract Product createProduct();
}
