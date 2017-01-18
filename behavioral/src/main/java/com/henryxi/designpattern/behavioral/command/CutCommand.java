package com.henryxi.designpattern.behavioral.command;

public class CutCommand implements Command {
    private Document document;

    public CutCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.cut();
    }

    @Override
    public void undo() {
        document.undoCut();
    }
}
