package com.thoughtworks.librarysys;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReturnBookMenuItemTest {

    @Test
    public void shouldReturnABookFromTheUserToTheLibraryByTheInputNameOfTheBook() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Inferno\n".getBytes());
        System.setIn(inputStream);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book book = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(book);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library);

        assertEquals("Done\n", returnBookMenuItem.performOperation());
        System.setIn(System.in);
    }

    @Test
    public void shouldNotReturnABookToTheLibraryThatDoesNotBelongToIt() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Head First Java\n".getBytes());
        System.setIn(inputStream);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book book = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(book);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library);

        assertEquals("Can't perform OP\n", returnBookMenuItem.performOperation());
        System.setIn(System.in);
    }
}