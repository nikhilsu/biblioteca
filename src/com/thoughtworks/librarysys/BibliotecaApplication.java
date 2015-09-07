package com.thoughtworks.librarysys;

import java.util.Scanner;

//Biblioteca application creates the necessary objects to run the application
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
        printToConsole(welcomeUser.toString());
        printToConsole(mainMenuItem.performOperation());
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        String choice = consoleInput.inputFromUser();
        InputParser inputParser = new InputParser(mainMenuItem, library);
        MainMenuItem parsedMainMenuType = inputParser.parse(choice);
        String outputMessageFromMenuItem = parsedMainMenuType.performOperation();
        printToConsole(outputMessageFromMenuItem);
    }

    private void printToConsole(String stringToPrint) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(stringToPrint);
        consoleDisplay.displayOnScreen();
    }
}
