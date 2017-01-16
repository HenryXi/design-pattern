package com.henryxi.designpattern.behavioral.iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int index;
    private T[] items;

    public ArrayIterator(ArrayAggregate<T> tArrayAggregate) {
        items = tArrayAggregate.allItems();
    }

    @Override
    public T next() {
        return items[index++];
    }

    @Override
    public boolean hasNext() {
        return index <= items.length - 1;
    }
}
