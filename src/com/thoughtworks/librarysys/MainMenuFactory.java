package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class MainMenuFactory {
    private ConsoleView consoleView;

    public MainMenuFactory(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public MainMenu manufacture(User user){
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        if (user.getRole().equals("Registered")) {
            listOfMenuItems.add("1. List Books");
            listOfMenuItems.add("2. List Movies");
            listOfMenuItems.add("3. Checkout Movie");
            listOfMenuItems.add("4. CheckOut Book");
            listOfMenuItems.add("5. Return Book");
            listOfMenuItems.add("6. Logout");
            return new MainMenu(listOfMenuItems, consoleView);
        }

        else if (user.getRole().equals("Librarian")) {
            listOfMenuItems.add("1. List Books");
            listOfMenuItems.add("2. List Movies");
            listOfMenuItems.add("3. Checkout Movie");
            listOfMenuItems.add("4. CheckOut Book");
            listOfMenuItems.add("5. Return Book");
            listOfMenuItems.add("6. CheckedOut Book Details");
            listOfMenuItems.add("7. Logout");
            return new MainMenu(listOfMenuItems, consoleView);
        }
        else {
            listOfMenuItems.add("1. List Books");
            listOfMenuItems.add("2. List Movies");
            listOfMenuItems.add("3. Checkout Movie");
            listOfMenuItems.add("4. Login");
            listOfMenuItems.add("5. Quit");
            return new MainMenu(listOfMenuItems, consoleView);
        }
    }
}
