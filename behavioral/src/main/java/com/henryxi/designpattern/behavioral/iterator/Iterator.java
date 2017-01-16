package com.henryxi.designpattern.behavioral.iterator;

public interface Iterator<T> {
    T next();
    boolean hasNext();
}
