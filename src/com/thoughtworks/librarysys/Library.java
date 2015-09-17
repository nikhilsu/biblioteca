package com.thoughtworks.librarysys;

public class Library {
    private Books books;
    private Movies movies;

    public Library(Books books, Movies movies) {
        this.books = books;
        this.movies = movies;
    }

    public void checkOut(Book bookToCheckOut, User currentUser) {
        books.checkOut(bookToCheckOut, currentUser);
    }

    public void checkOut(Movie movieToCheckout) {
        movies.checkOut(movieToCheckout);
    }

    public void toReturn(Book bookToReturn, User currentUser) {
        books.toReturn(bookToReturn, currentUser);
    }

    public String listBookCheckoutDetails() {
        return books.listCheckoutDetails();
    }

    public String listBooks() {
        return books.displayListOfBookDetails();
    }

    public String listMovies() {
        return movies.displayListOfDetails();
    }
}

