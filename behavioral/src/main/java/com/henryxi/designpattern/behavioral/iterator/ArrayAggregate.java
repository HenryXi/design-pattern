package com.henryxi.designpattern.behavioral.iterator;

public class ArrayAggregate<T> implements Aggregate<T> {

    private T[] items;

    public ArrayAggregate(T[] items) {
        this.items = items;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ArrayIterator<>(this);
    }

    public T[] allItems() {
        return items;
    }
}
