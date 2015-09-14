package com.thoughtworks.librarysys;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//Biblioteca Application constructs and assembles the dependencies of the controller, initiates and runs it.
public class BibliotecaApplication {
    private Scanner scanner;
    private PrintStream printStream;
    private ConsoleView consoleView;
    private LibraryObserver libraryObserver;
    private Library library;
    private MenuItem menuItem;
    private InputParser inputParser;
    private WelcomeUser welcomeUser;

    private ArrayList<Book> manufactureListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        Book bookThree = new Book("Gone Girl", "Gillian Flynn", 2014);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        return listOfBooks;
    }

    private ArrayList<String> manufactureListOfMenuItems() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        return listOfMenuItems;
    }

    private WelcomeUser manufactureWelcomeUser() {
        return new WelcomeUser("Welcome To Biblioteca Application");
    }

    public void createDependencies() {
        this.scanner = new Scanner(System.in);
        this.printStream = new PrintStream(System.out);
        this.consoleView = new ConsoleView(scanner, printStream);
        this.libraryObserver = new LibraryObserver(consoleView);
        ArrayList<Book> listOfBooks = manufactureListOfBooks();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        this.library = new Library(listOfBooks, listOfCheckedOutBooks, libraryObserver);
        this.inputParser = new InputParser(library, consoleView);
        ArrayList<String> listOfMenuItems = manufactureListOfMenuItems();
        this.menuItem = new MenuItem(listOfMenuItems, consoleView);
        this.welcomeUser = manufactureWelcomeUser();
    }
}
