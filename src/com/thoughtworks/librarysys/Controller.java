package com.thoughtworks.librarysys;

//Biblioteca application creates the necessary objects to run the application
public class Controller {
    private MainMenuFactory mainMenuFactory;
    private InputParserFactory inputParserFactory;
    private ConsoleView consoleView;
    private User currentUser;

    public Controller(MainMenuFactory mainMenuFactory, InputParserFactory inputParserFactory, ConsoleView consoleView, User currentUser) {
        this.mainMenuFactory = mainMenuFactory;
        this.inputParserFactory = inputParserFactory;
        this.consoleView = consoleView;
        this.currentUser = currentUser;
    }

    public void run() {
        MainMenu mainMenu = mainMenuFactory.manufacture(currentUser);
        mainMenu.performOperation();
        String choice = consoleView.inputFromUser();
        InputParser inputParser = inputParserFactory.manufacture(currentUser);
        MenuOptions parsedMainMenuType = inputParser.parse(choice);
        parsedMainMenuType.performOperation();
        if(parsedMainMenuType.getClass() == LoginMenuItem.class) {
            LoginMenuItem loginMenuItem = (LoginMenuItem) parsedMainMenuType;
            currentUser = loginMenuItem.getUser();
        }
        else if(parsedMainMenuType.getClass() == LogoutMenuItem.class) {
            LogoutMenuItem logoutMenuItem = (LogoutMenuItem) parsedMainMenuType;
            currentUser = logoutMenuItem.getUser();
        }
    }
}