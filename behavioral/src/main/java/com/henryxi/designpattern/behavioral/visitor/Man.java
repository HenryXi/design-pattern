package com.henryxi.designpattern.behavioral.visitor;

public class Man implements Person {
    private String name = "man";

    @Override
    public void accept(Status status) {
        status.visitMan(this);
    }

    public String getName() {
        return name;
    }
}
