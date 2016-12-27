package com.henryxi.designpattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<NewInterface> newInterfaces = new ArrayList<>();
        newInterfaces.add(new NewInterfaceImplA());
        newInterfaces.add(new NewInterfaceImplB());
        newInterfaces.add(new NewInterfaceAdapter());//new adapter and handle it as an implementation of NewInterface
        handleNewInterface(newInterfaces);
    }

    private static void handleNewInterface(List<NewInterface> newInterfaceList){
        for (NewInterface impl : newInterfaceList) {
            impl.newMethod();
        }
    }
}
