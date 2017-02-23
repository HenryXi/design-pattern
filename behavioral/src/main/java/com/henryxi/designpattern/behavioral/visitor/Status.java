package com.henryxi.designpattern.behavioral.visitor;

public interface Status {
    void visitWoman(Woman woman);

    void visitMan(Man man);
}
