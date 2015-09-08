package com.thoughtworks.librarysys;

import org.junit.Test;

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
        InputParser inputParser = new InputParser(library);

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
        InputParser inputParser = new InputParser(library);

        String userChoice = "2";

        assertEquals(new CheckoutBookMenuItem(library).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeQuitMenuItemWhenTheUsersChoiceOfMenuItemIsTwo() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        InputParser inputParser = new InputParser(library);

        String userChoice = "3";

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
        InputParser inputParser = new InputParser(library);

        String userChoice = "0";
        assertEquals(new InvalidMenuItem("Select a valid option!").getClass(), inputParser.parse(userChoice).getClass());
    }
}