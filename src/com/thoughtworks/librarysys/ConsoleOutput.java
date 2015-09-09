package com.thoughtworks.librarysys;

import java.io.PrintStream;

//Takes in a message and prints it on the console
public class ConsoleOutput {
    String message;

    public ConsoleOutput(String message) {
        this.message = message;
    }

    public void displayOnScreen() {
        System.out.print(message);
    }
}
