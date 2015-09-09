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

        printToScreen(welcomeUser.toString());
        printToScreen(mainMenuItem.performOperation());
        String choice = consoleInput.inputFromUser();
        InputParser inputParser = new InputParser(library, consoleInput);
        MainMenuItem parsedMainMenuType = inputParser.parse(choice);
        String outputMessageFromMenuItem = parsedMainMenuType.performOperation();
        printToScreen(outputMessageFromMenuItem);
    }

    private void printToScreen(String messageToPrint) {
        ConsoleOutput consoleOutput = new ConsoleOutput(messageToPrint);
        consoleOutput.displayOnScreen();
    }
}