package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnTheNameOfTheBookAuthorAndYearOfPublicationInAFormattedString() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        String testString = "Kite Runner\tKhaled Hossieni\t2003\n";

        assertEquals(testString, book.toString());
    }
}