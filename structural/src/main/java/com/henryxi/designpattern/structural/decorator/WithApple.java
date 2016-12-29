package com.henryxi.designpattern.structural.decorator;

public class WithApple extends PieDecorator {
    public WithApple(Pie c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Apple";
    }
}
