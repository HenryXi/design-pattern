package com.henryxi.designpattern.behavioral.iterator;

public class Client {
    public static void main(String[] args) {
        ArrayAggregate<Integer> arrayAggregate = new ArrayAggregate<>(new Integer[]{1, 2, 3});
        Iterator<Integer> iterator = arrayAggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
