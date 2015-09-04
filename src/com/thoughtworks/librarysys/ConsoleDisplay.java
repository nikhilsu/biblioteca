package com.thoughtworks.librarysys;

import java.util.ArrayList;

//Takes in a string and prints it on the console
public class ConsoleDisplay {
    private ArrayList<String> message;

    public ConsoleDisplay(ArrayList<String> message) {
        this.message = message;
    }

    public void displayOnScreen() {
        for (String mess : message) {
            System.out.println(mess);
        }
    }
}
