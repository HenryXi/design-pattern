package com.henryxi.designpattern.behavioral.mediator;

public class TextColleague extends Colleague {

    public TextColleague(Mediator m) {
        super(m);
    }

    public void handleEvent(String message) {
        System.out.println("Text handle event: " + message);
    }
}
