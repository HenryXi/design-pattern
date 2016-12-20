package com.henryxi.designpattern.creational.lazyinitialization;

public class Client {
    public static void main(String[] args) {
        Product productA = Product.getProductByName("A");
        Product.showAllProduct();
        Product productB = Product.getProductByName("B");
        Product.showAllProduct();
    }
}
