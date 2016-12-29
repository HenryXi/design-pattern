package com.henryxi.designpattern.structural.decorator;

public class SimplePie implements Pie {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Pie";
    }
}
