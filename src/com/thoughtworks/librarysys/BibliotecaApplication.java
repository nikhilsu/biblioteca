package com.thoughtworks.librarysys;

import java.util.Scanner;

public class BibliotecaApplication {
    WelcomeUser welcomeUser;
    MainMenuItem mainMenuItem;
    Library library;

    public BibliotecaApplication(WelcomeUser welcomeUser, MainMenuItem mainMenuItem, Library library) {
        this.welcomeUser = welcomeUser;
        this.mainMenuItem = mainMenuItem;
        this.library = library;
    }

    public void run() {
        new ConsoleDisplay(welcomeUser.toString()).displayOnScreen();
        new ConsoleDisplay(mainMenuItem.toString()).displayOnScreen();
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        String choice = consoleInput.inputFromUser();
        if (choice.equals(""))
            return;
        if (choice.equals("1"))
            new ConsoleDisplay(library.toString()).displayOnScreen();
        else if (choice.equals("2"))
            System.exit(0);
        else
            new ConsoleDisplay("Select a valid option!").displayOnScreen();
    }
}
