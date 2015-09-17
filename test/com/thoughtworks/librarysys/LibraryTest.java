package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldCheckOutABookPassedToIt() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        User user = mock(User.class);
        Book bookToCheckOut = new Book("Book", "Author", 0);
        library.checkOut(bookToCheckOut, user);

        verify(books).checkOut(bookToCheckOut, user);
    }

    @Test
    public void shouldCheckOutAMoviePassedToIt() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);

        Movie movieToCheckOut = new Movie("Movie", 1000, "Director", 0);
        library.checkOut(movieToCheckOut);

        verify(movies).checkOut(movieToCheckOut);
    }

    @Test
    public void shouldReturnABook() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        User user = mock(User.class);

        Book bookToReturn = new Book("Book", "Author", 0);
        library.toReturn(bookToReturn, user);

        verify(books).toReturn(bookToReturn, user);
    }

    @Test
    public void shouldListTheDetailsOfBooksOfTheLibrary() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);

        library.listBooks();

        verify(books).displayListOfDetails();
    }

    @Test
    public void shouldListTheDetailsOfMoviesOfTheLibrary() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);

        library.listMovies();

        verify(movies).displayListOfDetails();
    }
}