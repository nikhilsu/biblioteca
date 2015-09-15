package com.thoughtworks.librarysys;

public class Library {
    private Books books;
    private Movies movies;

    public Library(Books books, Movies movies) {
        this.books = books;
        this.movies = movies;
    }

    public void checkOut(Book bookToCheckOut) {
        books.checkOut(bookToCheckOut);
    }

    public void checkOut(Movie movieToCheckout) {
        movies.checkOut(movieToCheckout);
    }

    public void toReturn(Book bookToReturn) {
        books.toReturn(bookToReturn);
    }
}

