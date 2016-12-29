package com.henryxi.designpattern.structural.decorator;

public class Client {
    public static void printInfo(Pie c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }

    public static void main(String[] args) {
        Pie c = new SimplePie();
        printInfo(c);

        c = new WithBlueberry(c);
        printInfo(c);

        c = new WithApple(c);
        printInfo(c);
    }
}
