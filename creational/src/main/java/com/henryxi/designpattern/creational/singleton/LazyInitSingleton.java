package com.henryxi.designpattern.creational.singleton;

public class LazyInitSingleton {
    private static LazyInitSingleton lazyInitSingleton;

    private LazyInitSingleton() {
    }

    public static synchronized LazyInitSingleton getInstance() {
        if (lazyInitSingleton == null) {
            lazyInitSingleton = new LazyInitSingleton();
        }
        return lazyInitSingleton;
    }
}
