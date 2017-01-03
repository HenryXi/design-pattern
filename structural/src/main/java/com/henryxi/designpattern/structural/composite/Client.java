package com.henryxi.designpattern.structural.composite;

public class Client {
    public static void main(String[] args) {
        File file1 = new TxtFile("file1");
        File file2 = new TxtFile("file2");
        File file3 = new TxtFile("file3");
        File file4 = new TxtFile("file4");
        Directory directory1 = new Directory("directory1");
        Directory directory2 = new Directory("directory2");
        directory1.add(file1);
        directory1.add(file2);
        directory2.add(file3);
        directory2.add(file4);
        directory1.add(directory2);
        directory1.print();
    }
}
