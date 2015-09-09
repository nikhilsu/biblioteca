package com.thoughtworks.librarysys;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

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
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleInput);

        assertEquals("Thank you for returning the book\n", returnBookMenuItem.performOperation());
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
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleInput);

        assertEquals("That is not a valid book to return\n", returnBookMenuItem.performOperation());
        System.setIn(System.in);
    }
}