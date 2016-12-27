package com.henryxi.designpattern.structural.adapter;

public class NewInterfaceImplA implements NewInterface {

    @Override
    public void newMethod() {
        System.out.println("this is implementA of new method");
    }
}
