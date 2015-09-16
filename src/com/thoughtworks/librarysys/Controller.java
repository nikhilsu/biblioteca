package com.thoughtworks.librarysys;

//Biblioteca application creates the necessary objects to run the application
public class Controller {
    private MainMenu mainMenu;
    private InputParser inputParser;
    private ConsoleView consoleView;
    private User currentUser;
    private Users users;

    public Controller(MainMenu mainMenu, InputParser inputParser, ConsoleView consoleView) {
        this.mainMenu = mainMenu;
        this.inputParser = inputParser;
        this.consoleView = consoleView;
    }

    public void run() {
        mainMenu.performOperation();
        String choice = consoleView.inputFromUser();
        MenuOptions parsedMainMenuType = inputParser.parse(choice);
        parsedMainMenuType.performOperation();
    }
}