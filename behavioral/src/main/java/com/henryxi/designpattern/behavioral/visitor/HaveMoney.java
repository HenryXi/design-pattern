package com.henryxi.designpattern.behavioral.visitor;

public class HaveMoney implements Status {
    private String status = "have money";

    @Override
    public void visitWoman(Woman woman) {
        System.out.println("when " + woman.getName() + " " + status + " buy! buy! buy!");

    }

    @Override
    public void visitMan(Man man) {
        System.out.println("when " + man.getName() + " " + status + " invest.");
    }
}
