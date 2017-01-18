package com.henryxi.designpattern.behavioral.command;

public class PasteCommand implements Command {
    private Document document;

    public PasteCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.paste();
    }

    @Override
    public void undo() {
        document.undoPaste();
    }
}