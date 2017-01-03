package com.henryxi.designpattern.structural.flyweight;

public class ConcreteCharacter extends Character {
    private String name;

    public ConcreteCharacter(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
