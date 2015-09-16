package com.thoughtworks.librarysys;

public class LoginMenuItem implements MenuOptions {
    private Users users;
    private User user;
    private ConsoleView consoleView;

    public LoginMenuItem(Users users, ConsoleView consoleView) {
        this.users = users;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter Library ID : ");
        String userLibraryID = consoleView.inputFromUser();
        consoleView.printOnConsole("Enter Password : ");
        String password = consoleView.inputFromUser();
        this.user = users.authenticate(userLibraryID, password);
    }
}
