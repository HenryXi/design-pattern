package com.henryxi.designpattern.behavioral.command;

public class Client {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Document document = new Document();
        CutCommand cutCommand = new CutCommand(document);
        PasteCommand pasteCommand = new PasteCommand(document);
        menuItem.storeAndExecute(cutCommand);
        menuItem.storeAndExecute(pasteCommand);
        menuItem.undo();
    }
}
