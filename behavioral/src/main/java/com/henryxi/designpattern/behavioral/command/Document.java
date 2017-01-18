package com.henryxi.designpattern.behavioral.command;

public class Document {
    public void paste(){
        System.out.println("paste word into document");
    }

    public void undoPaste(){
        System.out.println("undo paste word into document");
    }

    public void cut(){
        System.out.println("cut word from document");
    }

    public void undoCut(){
        System.out.println("undo cut word from document");
    }
}
