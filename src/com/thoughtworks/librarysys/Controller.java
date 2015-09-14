package com.thoughtworks.librarysys;

//Biblioteca application creates the necessary objects to run the application
public class Controller {
    private WelcomeUser welcomeUser;
    private MenuItem menuItem;
    private Library library;
    private ConsoleView consoleView;

    public Controller(WelcomeUser welcomeUser, MenuItem menuItem, Library library, ConsoleView consoleView) {
        this.welcomeUser = welcomeUser;
        this.menuItem = menuItem;
        this.library = library;
        this.consoleView = consoleView;
    }

    public void run() {
        consoleView.printOnConsole(welcomeUser.toString());
        consoleView.printOnConsole(menuItem.performOperation());
        String choice = consoleView.inputFromUser();
        InputParser inputParser = new InputParser(library, consoleView);
        MenuItem parsedMainMenuType = inputParser.parse(choice);
        String outputMessageFromMenuItem = parsedMainMenuType.performOperation();
        consoleView.printOnConsole(outputMessageFromMenuItem);
    }
}