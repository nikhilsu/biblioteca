package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldReturnTheNameOfTheBookAuthorAndYearOfPublicationInAFormattedString() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        String testString = String.format("%s\t%s\t%s", "Kite Runner", "Khaled Hossieni", 2003);

        assertEquals(testString, book.displayDetails());
    }

    @Test
    public void isEqualToItself() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        assertEquals(book, book);
    }

    @Test
    public void isNotEqualToSomethingThatIsNotABook() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        assertNotEquals(book, "Book");
    }

    @Test
    public void isNotEqualToNull() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        assertNotEquals(book, null);
    }

    @Test
    public void hasSameHashCodeWhenMoviesAreSame() {
        Book book = new Book("Kite Runner", "Khaled Hossieni", 2003);

        assertEquals(book.hashCode(), book.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToAnotherBookWithSameState() {
        Book bookOne = new Book("Brief History of Time", "Stephen Hawking", 1988);
        Book bookTwo = new Book("Brief History of Time", "Stephen Hawking", 1988);

        assertEquals(bookOne.hashCode(), bookTwo.hashCode());
    }
}