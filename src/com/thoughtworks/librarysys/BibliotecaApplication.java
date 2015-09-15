package com.thoughtworks.librarysys;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//Biblioteca Application constructs and assembles the dependencies of the controller, initiates and runs it.
public class BibliotecaApplication {
    private Scanner scanner;
    private PrintStream printStream;
    private ConsoleView consoleView;
    private LibraryBooksObserver libraryBooksObserver;
    private Books books;
    private Movies movies;
    private MenuItem menuItem;
    private InputParser inputParser;
    private WelcomeUser welcomeUser;
    private Controller controller;
    private Library library;

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
        listOfMenuItems.add("5. List Movies");
        return listOfMenuItems;
    }

    private WelcomeUser manufactureWelcomeUser() {
        return new WelcomeUser("Welcome To Biblioteca Application");
    }

    public void createDependencies() {
        this.scanner = new Scanner(System.in);
        this.printStream = new PrintStream(System.out);
        this.consoleView = new ConsoleView(scanner, printStream);
        this.libraryBooksObserver = new LibraryBooksObserver(consoleView);
        ArrayList<Book> listOfBooks = manufactureListOfBooks();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        this.books = new Books(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        ArrayList<Movie> listOfMovies = manufactureListOfMovies();
        this.movies = new Movies(listOfMovies);
        this.library = new Library(books, movies);
        this.inputParser = new InputParser(library, consoleView);
        ArrayList<String> listOfMenuItems = manufactureListOfMenuItems();
        this.menuItem = new MenuItem(listOfMenuItems, consoleView);
        this.welcomeUser = manufactureWelcomeUser();
    }

    private ArrayList<Movie> manufactureListOfMovies() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        Movie movieTwo = new Movie("Gone Girl", 2014, "David Fincher", 8);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        return listOfMovies;
    }

    public void initialiseApplication() {
        this.consoleView.printOnConsole(welcomeUser.toString());
        this.controller = new Controller(menuItem, inputParser, consoleView);
    }

    public void start() {
        while (true)
            this.controller.run();
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.createDependencies();
        bibliotecaApplication.initialiseApplication();
        bibliotecaApplication.start();
    }
}
