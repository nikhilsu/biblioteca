package com.thoughtworks.librarysys;

import java.util.ArrayList;

//library has a list of books whose details are returned with a column header
public class Library {
    private ArrayList<Book> listOfBooksAvailable;
    private ArrayList<Book> listOfCheckedOutBooks;
    private ConsoleView consoleView;

    public Library(ArrayList<Book> listOfBooksAvailable, ArrayList<Book> listOfCheckedOutBooks, ConsoleView consoleView) {
        this.listOfBooksAvailable = listOfBooksAvailable;
        this.listOfCheckedOutBooks = listOfCheckedOutBooks;
        this.consoleView = consoleView;
    }

    @Override
    public String toString() {
        String listOfBookDetails = String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication");
        for (Book book : listOfBooksAvailable)
            listOfBookDetails += book.toString();
        return listOfBookDetails;
    }

    private void removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(int indexOfBook) {
        listOfCheckedOutBooks.add(listOfBooksAvailable.get(indexOfBook));
        listOfBooksAvailable.remove(indexOfBook);
    }

    private void removeBookFromCheckedOutBookListAndAddItToAvailableBooksList(int indexOfBookToBeReturned) {
        listOfBooksAvailable.add(listOfCheckedOutBooks.get(indexOfBookToBeReturned));
        listOfCheckedOutBooks.remove(indexOfBookToBeReturned);
    }

    public void checkOut(Book bookToCheckout) {
        int indexOfBook = listOfBooksAvailable.indexOf(bookToCheckout);
        if (indexOfBook != -1) {
            removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(indexOfBook);
            consoleView.notifySuccessfulBookCheckout();
        }
        else
        consoleView.notifyUnsuccessfulCheckout();
    }

    public void toReturn(Book bookToBeReturned) {
        int indexOfBookToBeReturned = listOfCheckedOutBooks.indexOf(bookToBeReturned);
        if (indexOfBookToBeReturned != -1) {
            removeBookFromCheckedOutBookListAndAddItToAvailableBooksList(indexOfBookToBeReturned);
            consoleView.notifySuccessfulReturn();
        }
        else
        consoleView.notifyUnsuccessfulReturn();
    }
}
