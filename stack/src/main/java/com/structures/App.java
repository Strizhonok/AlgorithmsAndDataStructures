package com.structures;

import com.structures.stack.Stack;

public class App {

    public static void main(String[] args) {
        Stack testStack = new Stack(5);
        testStack.push("test");
        testStack.push("stack");
        testStack.push("to");
        testStack.push("provide");
        testStack.pop();
        testStack.push("check");
        testStack.push("implementation");
    }

}
