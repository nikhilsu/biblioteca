package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public BookList(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        String listOfBookDetails = "Name Of The Book\tAuthor\tYear Of Publication\n";
        for (Book book : listOfBooks)
            listOfBookDetails += book.toString();
        return listOfBookDetails;
    }
}
