package com.henryxi.designpattern.creational.prototype;

public class ConcretePrototype1 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "this is ConcretePrototype1, name:" + super.getName();
    }
}
