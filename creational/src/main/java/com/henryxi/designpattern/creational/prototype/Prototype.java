package com.henryxi.designpattern.creational.prototype;

public abstract class Prototype implements Cloneable {
    private String name = "PrototypeName";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
