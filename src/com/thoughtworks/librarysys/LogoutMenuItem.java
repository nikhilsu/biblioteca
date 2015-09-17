package com.thoughtworks.librarysys;

public class LogoutMenuItem implements MenuOptions {
    private User user;
    private ConsoleView consoleView;

    public LogoutMenuItem(User user, ConsoleView consoleView) {
        this.user = user;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        this.user = new User("Not a member", "Not Known", "Guest");
        consoleView.printOnConsole("Successfully Logged Out!\n\n");
    }

    public User getUser() {
        return user;
    }
}
