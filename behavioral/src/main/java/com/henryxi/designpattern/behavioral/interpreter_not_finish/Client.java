package com.henryxi.designpattern.behavioral.interpreter_not_finish;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        final String content = "x + y - z";
        Stack<String> expressionStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        for (String str : content.split(" ")) {
            switch (str) {
                case "+":
                    expressionStack.push("+");
                    break;
                case "_":
                    expressionStack.push("-");
                    break;
                default:

                    numberStack.push(Integer.valueOf(str));
                    break;
            }
        }

        final int result = 0;
        System.out.println(result);
    }
}
