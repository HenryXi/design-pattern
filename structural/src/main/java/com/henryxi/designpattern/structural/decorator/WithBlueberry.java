package com.henryxi.designpattern.structural.decorator;

public class WithBlueberry extends PieDecorator {
    public WithBlueberry(Pie c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Blueberry";
    }
}
