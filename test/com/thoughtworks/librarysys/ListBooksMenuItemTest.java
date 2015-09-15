package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksMenuItemTest {

    @Test
    public void shouldReturnTheListOfAllTheBooksInTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = new LibraryBooksObserver(consoleView);
        Books books = new Books(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(books, consoleView);

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n";
        listBooksMenuItem.performOperation();

        verify(consoleView).printOnConsole(testString);
    }

    @Test
    public void shouldReturnTheListOfAllTheBooksInTheLibraryWhenToStringMethodIsInvoked() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = new LibraryBooksObserver(consoleView);
        Books books = new Books(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(books, consoleView);

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n";

        assertEquals(testString, listBooksMenuItem.toString());
    }

}