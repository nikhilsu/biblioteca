package com.thoughtworks.librarysys;

//Biblioteca application creates the necessary objects to run the application
public class Controller {
    WelcomeUser welcomeUser;
    MainMenuItem mainMenuItem;
    Library library;
    ConsoleInput consoleInput;

    public Controller(WelcomeUser welcomeUser, MainMenuItem mainMenuItem, Library library, ConsoleInput consoleInput) {
        this.welcomeUser = welcomeUser;
        this.mainMenuItem = mainMenuItem;
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public void run() {
        printToConsole(welcomeUser.toString());
        printToConsole(mainMenuItem.performOperation());
        String choice = consoleInput.inputFromUser();
        InputParser inputParser = new InputParser(library);
        MainMenuItem parsedMainMenuType = inputParser.parse(choice);
        String outputMessageFromMenuItem = parsedMainMenuType.performOperation();
        printToConsole(outputMessageFromMenuItem);
    }

    private void printToConsole(String stringToPrint) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(stringToPrint);
        consoleDisplay.displayOnScreen();
    }
}