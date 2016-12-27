package com.henryxi.designpattern.structural.adapter;

public class NewInterfaceAdapter implements NewInterface {

    private LegacyClass legacyClass = new LegacyClass();

    @Override
    public void newMethod() {
        legacyClass.originMethod();
    }
}
