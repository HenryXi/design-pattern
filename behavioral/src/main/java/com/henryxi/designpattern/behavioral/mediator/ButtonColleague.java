package com.henryxi.designpattern.behavioral.mediator;

public class ButtonColleague extends Colleague {
    public ButtonColleague(Mediator m) {
        super(m);
    }

    public void handleEvent(String message) {
        System.out.println("Button handle event: " + message);
    }
}
