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
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(welcomeUser.toString());
        consoleDisplay.displayOnScreen();
        consoleDisplay = new ConsoleDisplay(mainMenuItem.performOperation());
        consoleDisplay.displayOnScreen();
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        String choice = consoleInput.inputFromUser();
        InputParser inputParser = new InputParser(mainMenuItem, library);
        MainMenuItem parserOutput = inputParser.parse(choice);
        String outputMessageFromMenuItem = parserOutput.performOperation();
        consoleDisplay = new ConsoleDisplay(outputMessageFromMenuItem);
        consoleDisplay.displayOnScreen();
    }
}
