package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldReturnTheNamesOfAllTheBooksInTheList() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        BookList bookList = new BookList(listOfBooks);

        String testString = "Name Of The Book\tAuthor\tYear Of Publication\n" +
                "Gone Girl\tGillian Flynn\t2014\n" +
                "Kite Runner\tKhaled Hossieni\t2003\n" +
                "Inferno\tDan Brown\t2012\n";

        assertEquals(testString, bookList.toString());
    }
}