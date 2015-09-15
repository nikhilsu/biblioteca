package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldCheckOutABookPassedToIt() {
        Books books = mock(Books.class);
        Library library = new Library(books);

        Book bookToCheckOut = new Book("Book", "Author", 0);
        library.checkOut(bookToCheckOut);

        verify(books).checkOut(bookToCheckOut);
    }
}