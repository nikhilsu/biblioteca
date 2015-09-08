package com.thoughtworks.librarysys;

import java.util.ArrayList;

//library has a list of books whose details are returned with a column header
public class Library {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        String listOfBookDetails = String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication");
        for (Book book : listOfBooks)
            listOfBookDetails += book.toString();
        return listOfBookDetails;
    }

    public boolean checkOut(Book book) {
        if (listOfBooks.contains(book)) {
            listOfBooks.remove(book);
            return true;
        }

        else
        return false;
    }
}
