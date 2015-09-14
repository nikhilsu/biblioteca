package com.thoughtworks.librarysys;

import java.util.ArrayList;

//library has a list of books whose details are returned with a column header
public class LibraryBooks implements LibraryOperations{
    private ArrayList<Book> listOfBooksAvailable;
    private ArrayList<Book> listOfCheckedOutBooks;
    private LibraryBooksObserver libraryBooksObserver;

    public LibraryBooks(ArrayList<Book> listOfBooksAvailable, ArrayList<Book> listOfCheckedOutBooks, LibraryBooksObserver libraryBooksObserver) {
        this.listOfBooksAvailable = listOfBooksAvailable;
        this.listOfCheckedOutBooks = listOfCheckedOutBooks;
        this.libraryBooksObserver = libraryBooksObserver;
    }

    @Override
    public String displayListOfDetails() {
        String listOfBookDetails = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0","-");
        for (Book book : listOfBooksAvailable)
            listOfBookDetails += book.displayDetails();
        return listOfBookDetails + "\n";
    }

    private void removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(int indexOfBook) {
        listOfCheckedOutBooks.add(listOfBooksAvailable.get(indexOfBook));
        listOfBooksAvailable.remove(indexOfBook);
    }

    private void removeBookFromCheckedOutBookListAndAddItToAvailableBooksList(int indexOfBookToBeReturned) {
        listOfBooksAvailable.add(listOfCheckedOutBooks.get(indexOfBookToBeReturned));
        listOfCheckedOutBooks.remove(indexOfBookToBeReturned);
    }

    @Override
    public void checkOut(LibraryItem bookToCheckout) {
        int indexOfBook = listOfBooksAvailable.indexOf(bookToCheckout);
        if (indexOfBook != -1) {
            removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(indexOfBook);
            libraryBooksObserver.notifySuccessfulBookCheckout();
        }
        else
            libraryBooksObserver.notifyUnsuccessfulCheckout();
    }

    public void toReturn(Book bookToBeReturned) {
        int indexOfBookToBeReturned = listOfCheckedOutBooks.indexOf(bookToBeReturned);
        if (indexOfBookToBeReturned != -1) {
            removeBookFromCheckedOutBookListAndAddItToAvailableBooksList(indexOfBookToBeReturned);
            libraryBooksObserver.notifySuccessfulReturn();
        }
        else
            libraryBooksObserver.notifyUnsuccessfulReturn();
    }
}
