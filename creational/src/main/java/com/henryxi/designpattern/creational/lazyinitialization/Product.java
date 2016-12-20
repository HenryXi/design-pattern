package com.henryxi.designpattern.creational.lazyinitialization;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Map<String, Product> types = new HashMap<>();

    private Product(String name) {
        this.name = name;
    }

    public static Product getProductByName(String productName) {
        if (!types.containsKey(productName)) {
            types.put(productName, new Product(productName));
        }
        return types.get(productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void showAllProduct() {
        System.out.println(types);
    }
}
