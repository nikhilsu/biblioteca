package com.thoughtworks.librarysys;

//Biblioteca application creates the necessary objects to run the application
public class Controller {
    private MenuItem menuItem;
    private Library library;
    private InputParser inputParser;
    private ConsoleView consoleView;

    public Controller(MenuItem menuItem, Library library, InputParser inputParser, ConsoleView consoleView) {
        this.menuItem = menuItem;
        this.library = library;
        this.inputParser = inputParser;
        this.consoleView = consoleView;
    }


    public void run() {
        menuItem.performOperation();
        String choice = consoleView.inputFromUser();
        MenuItem parsedMainMenuType = inputParser.parse(choice);
        parsedMainMenuType.performOperation();
    }
}