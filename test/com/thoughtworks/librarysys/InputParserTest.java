package com.thoughtworks.librarysys;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InputParserTest {

    @Test
    public void shouldReturnAnObjectOfTypeListBooksWhenTheUsersChoiceOfMenuItemIsOne() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "1";

        assertEquals(new ListBooksMenuItem(library).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeCheckoutBookMenuItemWhenTheUsersChoiceOfMenuItemIsTwo() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "2";

        assertEquals(new CheckoutBookMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeQuitMenuItemWhenTheUsersChoiceOfMenuItemIsFour() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "4";

        assertEquals(new QuitMenuItem().getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeInvalidMenuChoiceWhenTheUsersChoiceOfMenuItemIsInvalid() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "0";

        assertEquals(new InvalidMenuItem("Select a valid option!").getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeReturnBookMenuItemWhenTheUsersChoiceOfMenuItemIsThree() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "3";

        assertEquals(new ReturnBookMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }
}