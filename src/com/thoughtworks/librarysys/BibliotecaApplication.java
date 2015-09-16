package com.thoughtworks.librarysys;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Biblioteca Application constructs and assembles the dependencies of the controller, initiates and runs it.
public class BibliotecaApplication {
    private Scanner scanner;
    private PrintStream printStream;
    private ConsoleView consoleView;
    private LibraryObserver libraryObserver;
    private Books books;
    private Movies movies;
    private MainMenuFactory mainMenuFactory;
    private InputParserFactory inputParserFactory;
    private WelcomeUser welcomeUser;
    private Controller controller;
    private Library library;
    private User user;
    private Users users;

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
        this.books = new Books(listOfBooks, listOfCheckedOutBooks, libraryObserver);
        ArrayList<Movie> listOfMovies = manufactureListOfMovies();
        this.movies = new Movies(listOfMovies, libraryObserver);
        this.library = new Library(books, movies);
        ArrayList<User> listOfRegisteredUsers = manufactureListOfRegisteredUsers();
        this.users = new Users(listOfRegisteredUsers);
        this.inputParserFactory = new InputParserFactory(library, consoleView, users);
        this.mainMenuFactory = new MainMenuFactory(consoleView);
        this.welcomeUser = manufactureWelcomeUser();
        this.user = new User("Not a member", "Not known", "Guest");
    }

    private ArrayList<User> manufactureListOfRegisteredUsers() {
        User userOne = new User("111-1111", "password1", "Registered");
        User userTwo = new User("222-2222", "password2", "Registered");
        User userThree = new User("333-3333", "password3", "Registered");
        User admin = new User("999-9999", "confidential", "Librarian");
        return new ArrayList<>(Arrays.asList(userOne, userTwo, userThree, admin));
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
        this.controller = new Controller(mainMenuFactory, inputParserFactory, consoleView, user);
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
