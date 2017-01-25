package com.henryxi.designpattern.behavioral.interpreter_not_finish;

import java.util.Map;

public interface Expression {
    public int interpret(final Map<String, Expression> variables);
}
