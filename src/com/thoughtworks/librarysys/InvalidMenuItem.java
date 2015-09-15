package com.thoughtworks.librarysys;

//invalidmenuitem is a mainmenuitem that return "select a valic option!" string
public class InvalidMenuItem implements MenuOptions {
    private String displayMessage;
    private ConsoleView consoleView;

    public InvalidMenuItem(String displayMessage, ConsoleView consoleView) {
        this.displayMessage = displayMessage + "\n";
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
         consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return displayMessage;
    }
}

