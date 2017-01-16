package com.henryxi.designpattern.behavioral.iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}
