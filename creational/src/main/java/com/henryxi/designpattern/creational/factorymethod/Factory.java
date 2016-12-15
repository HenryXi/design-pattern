package com.henryxi.designpattern.creational.factorymethod;

public abstract class Factory {
    public String showProductName() {
        // start your business logic code
        Product product = createProduct();
        return product.getProductName();
    }

    abstract Product createProduct();// override this method to create different product in subclass
}
