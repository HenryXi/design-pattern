package com.henryxi.designpattern.structural.facade;

public class Facade {
    public void mainMethod(){
        SubClass1 subClass1 = new SubClass1();
        SubClass2 subClass2 = new SubClass2();
        SubClass3 subClass3 = new SubClass3();
        subClass1.method1();
        subClass2.method2();
        subClass3.method3();
    }
}
