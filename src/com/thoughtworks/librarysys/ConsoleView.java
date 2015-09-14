package com.thoughtworks.librarysys;

import java.io.PrintStream;
import java.util.Scanner;
//ConsoleView serves as an interface that can take input from the user and display a string
public class ConsoleView {
    private PrintStream printStream;
    private Scanner scanner;

    public ConsoleView(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public void printOnConsole(String message) {
        printStream.print(message);
    }

    public String inputFromUser() {
        return scanner.nextLine();
    }

    public void notifySuccessfulBookCheckout() {
        printOnConsole("Thank you! Enjoy the book\n");
    }
}
