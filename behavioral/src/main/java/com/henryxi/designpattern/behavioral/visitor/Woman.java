package com.henryxi.designpattern.behavioral.visitor;

public class Woman implements Person {

    private String name = "woman";

    @Override
    public void accept(Status status) {
        status.visitWoman(this);
    }

    public String getName() {
        return name;
    }
}
