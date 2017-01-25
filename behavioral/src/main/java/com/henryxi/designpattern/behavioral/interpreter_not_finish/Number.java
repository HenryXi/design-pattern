package com.henryxi.designpattern.behavioral.interpreter_not_finish;

import java.util.Map;

public class Number implements Expression {

    @Override
    public int interpret(Map<String, Expression> variables) {
        return 0;
    }
}
