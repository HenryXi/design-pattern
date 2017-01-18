package com.henryxi.designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private List<Command> history = new ArrayList<>();

    public void storeAndExecute(Command command) {
        history.add(command);
        command.execute();
    }

    public void undo() {
        for (int i = history.size() - 1; i >= 0; i--) {
            history.get(i).undo();
        }
    }
}
