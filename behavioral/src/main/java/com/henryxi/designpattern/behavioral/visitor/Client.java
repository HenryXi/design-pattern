package com.henryxi.designpattern.behavioral.visitor;

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        Person woman = new Woman();
        Person man = new Man();
        objectStructure.addPerson(woman);
        objectStructure.addPerson(man);

        Status happy = new Happy();
        objectStructure.showInfo(happy);

        Status sad = new Sad();
        objectStructure.showInfo(sad);

        // add new status
        Status haveMoney = new HaveMoney();
        objectStructure.showInfo(haveMoney);
    }
}
