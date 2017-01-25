package com.henryxi.designpattern.behavioral.mediator;

public class Client {
    public static void main(String[] args) {
        ApplicationMediator mediator = new ApplicationMediator();

        TextColleague text = new TextColleague(mediator);
        ButtonColleague button = new ButtonColleague(mediator);

        mediator.addColleague(text);
        mediator.addColleague(button);

        text.triggerEvent("Input text");
        button.triggerEvent("Click");
    }
}
