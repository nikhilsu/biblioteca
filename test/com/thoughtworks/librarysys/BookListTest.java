package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldReturnTheNamesOfAllTheBooksInTheList() {
        BookList bookList = new BookList();

        String testString = "Gone Girl\nInferno\nKite Runner\n";

        assertEquals(testString, bookList.toString());
    }
}