package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnTheNameOfTheBookAuthorAndYearOfPublicationInAFormattedString() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        String testString = String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003);

        assertEquals(testString, book.toString());
    }
}