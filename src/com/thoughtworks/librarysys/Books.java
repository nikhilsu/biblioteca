package com.thoughtworks.librarysys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private String getListOfBookDetails(String listOfBookDetails) {
        for (Book book : listOfBooksAvailable) {
             String [] tokensOfBookDetails = book.displayDetails().split("\t");
             listOfBookDetails += String.format("%-30s%-30s%-20s\n", tokensOfBookDetails[0], tokensOfBookDetails[1], tokensOfBookDetails[2]);
        }
        return listOfBookDetails;
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

    public String displayListOfBookDetails() {
        String listOfBookDetails = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0","-");
        listOfBookDetails = getListOfBookDetails(listOfBookDetails);
        return listOfBookDetails + "\n";
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

    public String listCheckoutDetails() {
        String bookChekOutDetails = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-25s%-25s%-25s%-20s\n", "Name of the book", "Author", "Year Of Publication", "Library ID") +
                String.format("%085d\n", 0).replace("0", "-");
        for (Map.Entry<Book, User> entry : listOfBooksCheckedOutByUsers.entrySet()) {
            String [] tokensOfBookDetails = entry.getKey().displayDetails().split("\t");
            String [] tokensOfUserDetails = entry.getValue().toString().split("\t");

            bookChekOutDetails += String.format("%-25s%-25s%-25s%-20s\n", tokensOfBookDetails[0], tokensOfBookDetails[1], tokensOfBookDetails[2], tokensOfUserDetails[0]);
        }
        return bookChekOutDetails + "\n";
    }
}
