package com.henryxi.designpattern.behavioral.mediator;

public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator m) {
        mediator = m;
    }

    public void triggerEvent(String event) {
        mediator.send(event, this);
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void handleEvent(String message);
}
