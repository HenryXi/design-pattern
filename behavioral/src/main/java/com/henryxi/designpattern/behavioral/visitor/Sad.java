package com.henryxi.designpattern.behavioral.visitor;

public class Sad implements Status {
    private String status = "sad";

    @Override
    public void visitWoman(Woman woman) {
        System.out.println("when " + woman.getName() + " " + status + " cry.");

    }

    @Override
    public void visitMan(Man man) {
        System.out.println("when " + man.getName() + " " + status + " drink.");
    }
}
