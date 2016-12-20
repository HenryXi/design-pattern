package com.henryxi.designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private static Map<String, Prototype> prototypeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        init();

        Prototype cloneType1 = getPrototype("prototype1");
        cloneType1.setName("clone type1");

        Prototype cloneType2 = getPrototype("prototype2");
        cloneType2.setName("clone type2");

        System.out.println("clone type1:" + cloneType1);
        System.out.println("clone type2:" + cloneType2);
    }

    private static void init() {
        Prototype prototype1 = new ConcretePrototype1();
        Prototype prototype2 = new ConcretePrototype2();
        prototypeMap.put("prototype1", prototype1);
        prototypeMap.put("prototype2", prototype2);
    }

    private static Prototype getPrototype(String prototypeName) throws Exception {
        Prototype prototype = prototypeMap.get(prototypeName);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new Exception("Prototype not found");
    }
}
