package com.thoughtworks.librarysys;

public class Library {
    private Books books;

    public Library(Books books) {
        this.books = books;
    }

    public void checkOut(Book bookToCheckOut) {
        books.checkOut(bookToCheckOut);
    }
}

