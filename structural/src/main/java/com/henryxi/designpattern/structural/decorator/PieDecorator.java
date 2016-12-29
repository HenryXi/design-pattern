package com.henryxi.designpattern.structural.decorator;

public abstract class PieDecorator implements Pie {
    protected final Pie decoratedPie;

    public PieDecorator(Pie c) {
        this.decoratedPie = c;
    }

    public double getCost() {
        return decoratedPie.getCost();
    }

    public String getIngredients() {
        return decoratedPie.getIngredients();
    }
}

