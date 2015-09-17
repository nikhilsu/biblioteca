package com.thoughtworks.librarysys;

import java.util.ArrayList;
import java.util.HashMap;

//library has a list of books whose details are returned with a column header
public class Books {
    private ArrayList<Book> listOfBooksAvailable;
    private HashMap<Book, User> listOfBooksCheckedOutByUsers;
    private LibraryObserver libraryObserver;

    public Books(ArrayList<Book> listOfBooksAvailable, HashMap<Book, User> listOfBooksCheckedOutByUsers, LibraryObserver libraryObserver) {
        this.listOfBooksAvailable = listOfBooksAvailable;
        this.listOfBooksCheckedOutByUsers = listOfBooksCheckedOutByUsers;
        this.libraryObserver = libraryObserver;
    }

    public String displayListOfDetails() {
        String listOfBookDetails = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0","-");
        for (Book book : listOfBooksAvailable)
            listOfBookDetails += book.displayDetails();
        return listOfBookDetails + "\n";
    }

    private void removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(int indexOfBook, User currentUser) {
        listOfBooksCheckedOutByUsers.put(listOfBooksAvailable.get(indexOfBook), currentUser);
        listOfBooksAvailable.remove(indexOfBook);
    }

    private void removeBookFromCheckoutListAndAddItToAvailableBooksList(Book bookToBeReturned) {
        for (Book book : listOfBooksCheckedOutByUsers.keySet())
            if (book.equals(bookToBeReturned)) {
                listOfBooksAvailable.add(book);
                listOfBooksCheckedOutByUsers.remove(book);
            }
    }

    public void checkOut(Book bookToCheckout, User currentUser) {
        int indexOfBook = listOfBooksAvailable.indexOf(bookToCheckout);
        if (indexOfBook != -1) {
            removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(indexOfBook, currentUser);
            libraryObserver.notifySuccessfulBookCheckout();
        }
        else
            libraryObserver.notifyUnsuccessfulBookCheckout();
    }

    public void toReturn(Book bookToBeReturned, User currentUser) {
        if(listOfBooksCheckedOutByUsers.containsKey(bookToBeReturned)) {
            if (listOfBooksCheckedOutByUsers.get(bookToBeReturned).equals(currentUser)) {
                removeBookFromCheckoutListAndAddItToAvailableBooksList(bookToBeReturned);
                libraryObserver.notifySuccessfulBookReturn();
            }
            else
                libraryObserver.notifyInvalidUser();
        }
        else
            libraryObserver.notifyUnsuccessfulBookReturn();
    }
}
