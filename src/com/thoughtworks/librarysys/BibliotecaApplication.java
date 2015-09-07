package com.thoughtworks.librarysys;

import java.util.Scanner;

public class BibliotecaApplication {
    WelcomeUser welcomeUser;
    MainMenu mainMenu;
    BookList bookList;

    public BibliotecaApplication(WelcomeUser welcomeUser, MainMenu mainMenu, BookList bookList) {
        this.welcomeUser = welcomeUser;
        this.mainMenu = mainMenu;
        this.bookList = bookList;
    }

    public void run() {
        new ConsoleDisplay(welcomeUser.toString()).displayOnScreen();
        new ConsoleDisplay(mainMenu.toString()).displayOnScreen();
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        String choice = consoleInput.inputFromUser();
        if (choice.equals(""))
            return;
        if (choice.equals("1"))
            new ConsoleDisplay(bookList.toString()).displayOnScreen();
        else if (choice.equals("2"))
            System.exit(0);
        else
            new ConsoleDisplay("Select a valid option!").displayOnScreen();
    }
}
