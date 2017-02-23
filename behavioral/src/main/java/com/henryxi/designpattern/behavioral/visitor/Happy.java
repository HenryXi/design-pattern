package com.henryxi.designpattern.behavioral.visitor;

public class Happy implements Status {

    private String status = "happy";

    @Override
    public void visitWoman(Woman woman) {
        System.out.println("when " + woman.getName() + " " + status + " smile.");

    }

    @Override
    public void visitMan(Man man) {
        System.out.println("when " + man.getName() + " " + status + " laugh.");
    }
}
