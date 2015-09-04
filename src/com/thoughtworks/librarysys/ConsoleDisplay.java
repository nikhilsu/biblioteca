package com.thoughtworks.librarysys;

//Takes in a message and prints it on the console
public class ConsoleDisplay {
    private String message;

    public ConsoleDisplay(String message) {
        this.message = message;
    }

    public void displayOnScreen() {
            System.out.println(message);
    }
}
