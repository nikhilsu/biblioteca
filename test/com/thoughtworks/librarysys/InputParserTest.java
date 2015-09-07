package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InputParserTest {
    @Test
    public void shouldReturnAnObjectOfTypeListBooksWhenTheUsersChoiceOfMenuItemIsOne() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List books");
        listOfMenuItems.add("2. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        Library library = new Library(listOfBooks);
        InputParser inputParser = new InputParser(mainMenuItem, library);

        assertEquals(new ListBooksMenuItem(library).getClass(), inputParser.parse("1").getClass());
    }
}