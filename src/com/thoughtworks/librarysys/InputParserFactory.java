package com.thoughtworks.librarysys;

import java.util.HashMap;

public class InputParserFactory {
    private Library library;
    private ConsoleView consoleView;

    public InputParserFactory(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    public InputParser manufacture(User user) {
        if (user.getRole().equals("Registered")){
            HashMap<String, MenuOptions> mapper = new HashMap<>();
            mapper.put("1", new ListBooksMenuItem(library, consoleView));
            mapper.put("2", new ListMovieMenuItem(library, consoleView));
            mapper.put("3", new CheckoutMovieMenuItem(library, consoleView));
            mapper.put("4", new CheckoutBookMenuItem(library, consoleView));
            mapper.put("5", new ReturnBookMenuItem(library, consoleView));
            mapper.put("6", new LogoutMenuItem());
            return new InputParser(consoleView, mapper);
        }
        else if (user.getRole().equals("Librarian")) {
            HashMap<String, MenuOptions> mapper = new HashMap<>();
            mapper.put("1", new ListBooksMenuItem(library, consoleView));
            mapper.put("2", new ListMovieMenuItem(library, consoleView));
            mapper.put("3", new CheckoutMovieMenuItem(library, consoleView));
            mapper.put("4", new CheckoutBookMenuItem(library, consoleView));
            mapper.put("5", new ReturnBookMenuItem(library, consoleView));
            mapper.put("6", new LogoutMenuItem());
            return new InputParser(consoleView, mapper);

        }
        else {
            HashMap<String, MenuOptions> mapper = new HashMap<>();
            mapper.put("1", new ListBooksMenuItem(this.library, consoleView));
            mapper.put("2", new CheckoutBookMenuItem(this.library, consoleView));
            mapper.put("3", new ReturnBookMenuItem(this.library, consoleView));
            mapper.put("4", new QuitMenuItem());
            mapper.put("5", new ListMovieMenuItem(this.library, consoleView));
            mapper.put("6", new CheckoutMovieMenuItem(this.library, consoleView));
            return new InputParser(consoleView, mapper);
        }
    }
}
