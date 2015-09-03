package com.thoughtworks.librarysys;

import java.util.ArrayList;

//Takes in a string and prints it on the console
public class ConsoleDisplay {
    private String message;
    private ArrayList<String> books;

    public ConsoleDisplay(String message, ArrayList<String> books) {
        this.message = message;
        this.books = books;
    }

    public void displayOnScreen() {
        System.out.println(message);
        for(String book : books){
            System.out.println(book);
        }
    }
}
