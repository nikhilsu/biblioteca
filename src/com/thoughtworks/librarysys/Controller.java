package com.thoughtworks.librarysys;

//Biblioteca application creates the necessary objects to run the application
public class Controller {
    private WelcomeUser welcomeUser;
    private MainMenuItem mainMenuItem;
    private Library library;
    private ConsoleView consoleView;

    public Controller(WelcomeUser welcomeUser, MainMenuItem mainMenuItem, Library library, ConsoleView consoleView) {
        this.welcomeUser = welcomeUser;
        this.mainMenuItem = mainMenuItem;
        this.library = library;
        this.consoleView = consoleView;
    }

    public void run() {
        consoleView.printOnConsole(welcomeUser.toString());
        consoleView.printOnConsole(mainMenuItem.performOperation());
        String choice = consoleView.inputFromUser();
        InputParser inputParser = new InputParser(library, consoleView);
        MainMenuItem parsedMainMenuType = inputParser.parse(choice);
        String outputMessageFromMenuItem = parsedMainMenuType.performOperation();
        consoleView.printOnConsole(outputMessageFromMenuItem);
    }
}