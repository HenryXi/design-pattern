package com.henryxi.designpattern.creational.prototype;

public class ConcretePrototype2 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "this is ConcretePrototype2, name:" + super.getName();
    }
}
