package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class BookList {
    private ArrayList<String> listOfBooks = new ArrayList<String>();

    public BookList() {
        listOfBooks.add("Gone Girl");
        listOfBooks.add("Inferno");
        listOfBooks.add("Kite Runner");
    }

    @Override
    public String toString() {
        String names = "";
        for (String bookName : listOfBooks)
            names += bookName + "\n";
        return names;
    }
}
