package com.thoughtworks.librarysys;

import java.util.HashMap;

public class InputParserFactory {
    private Library library;
    private ConsoleView consoleView;
    private Users users;

    public InputParserFactory(Library library, ConsoleView consoleView, Users users) {
        this.library = library;
        this.consoleView = consoleView;
        this.users = users;
    }

    public InputParser manufacture(User user) {
        if (user.getRole().equals("Registered")){
            HashMap<String, MenuOptions> mapper = new HashMap<>();
            mapper.put("1", new ListBooksMenuItem(library, consoleView));
            mapper.put("2", new ListMovieMenuItem(library, consoleView));
            mapper.put("3", new CheckoutMovieMenuItem(library, consoleView));
            mapper.put("4", new CheckoutBookMenuItem(library, consoleView, user));
            mapper.put("5", new ReturnBookMenuItem(library, consoleView, user));
            mapper.put("6", new LogoutMenuItem(user, consoleView));
            return new InputParser(consoleView, mapper);
        }
        else if (user.getRole().equals("Librarian")) {
            HashMap<String, MenuOptions> mapper = new HashMap<>();
            mapper.put("1", new ListBooksMenuItem(library, consoleView));
            mapper.put("2", new ListMovieMenuItem(library, consoleView));
            mapper.put("3", new CheckoutMovieMenuItem(library, consoleView));
            mapper.put("4", new CheckoutBookMenuItem(library, consoleView, user));
            mapper.put("5", new ReturnBookMenuItem(library, consoleView, user));
            mapper.put("6", new DetailsOfCheckedOutBooksMenuItem(library, consoleView));
            mapper.put("7", new LogoutMenuItem(user, consoleView));
            return new InputParser(consoleView, mapper);
        }
        else {
            HashMap<String, MenuOptions> mapper = new HashMap<>();
            mapper.put("1", new ListBooksMenuItem(this.library, consoleView));
            mapper.put("2", new ListMovieMenuItem(this.library, consoleView));
            mapper.put("3", new CheckoutMovieMenuItem(this.library, consoleView));
            mapper.put("4", new LoginMenuItem(this.users, this.consoleView));
            mapper.put("5", new QuitMenuItem());
            return new InputParser(consoleView, mapper);
        }
    }
}
