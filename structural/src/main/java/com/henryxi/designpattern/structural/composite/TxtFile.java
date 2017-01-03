package com.henryxi.designpattern.structural.composite;

public class TxtFile implements File {
    private String content;

    public TxtFile(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
