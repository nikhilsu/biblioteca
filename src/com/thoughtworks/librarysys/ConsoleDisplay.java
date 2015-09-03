package com.thoughtworks.librarysys;
//Takes in a string and prints it on the console
public class ConsoleDisplay {
    private String message;

    public ConsoleDisplay(String message) {
        this.message = message;
    }

    public void displayOnScreen() {
        System.out.print(message);
    }
}
