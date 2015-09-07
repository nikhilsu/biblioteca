package com.thoughtworks.librarysys;

import java.util.ArrayList;
//booklist has a list of books whose details are returned with a column header
public class Library {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        String listOfBookDetails = String.format("%-30s%-30s%-20s\n","Name Of The Book", "Author", "Year Of Publication");
        for (Book book : listOfBooks)
            listOfBookDetails += book.toString();
        return listOfBookDetails;
    }
}
