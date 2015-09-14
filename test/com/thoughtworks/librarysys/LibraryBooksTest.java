package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryBooksTest {

    @Test
    public void shouldReturnTheNamesOfAllTheBooksInTheList() {
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
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n";

        assertEquals(testString, libraryBooks.toString());
    }

    @Test
    public void shouldNotIncludeABookInItsListOnceItIsCheckedOut() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);

        libraryBooks.checkOut(bookTwo);

        verify(libraryBooksObserver).notifySuccessfulBookCheckout();
    }

    @Test
    public void cannotCheckoutABookThatIsNotPresentInTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);

        Book notALibraryBook = new Book("Head First java", "Bert Bates", 2003);
        libraryBooks.checkOut(notALibraryBook);

        verify(libraryBooksObserver).notifyUnsuccessfulCheckout();
    }

    @Test
    public void shouldReturnACheckedOutBookToTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(borrowedBook);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);

        Book libraryBook = new Book("Inferno", "Author", 0);
        libraryBooks.toReturn(libraryBook);

        verify(libraryBooksObserver).notifySuccessfulReturn();
    }

    @Test
    public void shouldNotReturnABookThatDoesNotBelongToTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(borrowedBook);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);

        Book libraryBook = new Book("Head First Java", "Author", 0);
        libraryBooks.toReturn(libraryBook);

        verify(libraryBooksObserver).notifyUnsuccessfulReturn();
    }

    @Test
    public void shouldContainTheBookWhichWasReturnedInTheListOfAvailableBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(borrowedBook);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        Book libraryBook = new Book("Inferno", "Author", 0);

        libraryBooks.toReturn(libraryBook);
        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n";

        assertEquals(testString, libraryBooks.toString());
    }
}