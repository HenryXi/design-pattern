package com.henryxi.designpattern.behavioral.mediator;

public interface Mediator {
    public void send(String message, Colleague colleague);
}
