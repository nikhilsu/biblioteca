package com.thoughtworks.librarysys;

import java.util.ArrayList;

//library has a list of books whose details are returned with a column header
public class Library {
    private ArrayList<Book> listOfBooksAvailable;
    private ArrayList<Book> listOfCheckedOutBooks;

    public Library(ArrayList<Book> listOfBooksAvailable, ArrayList<Book> listOfCheckedOutBooks) {
        this.listOfBooksAvailable = listOfBooksAvailable;
        this.listOfCheckedOutBooks = listOfCheckedOutBooks;
    }

    @Override
    public String toString() {
        String listOfBookDetails = String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication");
        for (Book book : listOfBooksAvailable)
            listOfBookDetails += book.toString();
        return listOfBookDetails;
    }

    public boolean checkOut(Book bookToCheckout) {
        int indexOfBook = listOfBooksAvailable.indexOf(bookToCheckout);
        if (indexOfBook != -1) {
            removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(indexOfBook);
            return true;
        }
        else
        return false;
    }

    private void removeBookFromAvailableBooksListAndAddItToCheckedOutBookList(int indexOfBook) {
        listOfCheckedOutBooks.add(listOfBooksAvailable.get(indexOfBook));
        listOfBooksAvailable.remove(indexOfBook);
    }

    public boolean toReturn(Book bookToBeReturned) {
        int indexOfBookToBeReturned = listOfCheckedOutBooks.indexOf(bookToBeReturned);
        if (indexOfBookToBeReturned != -1){
            removeBookFromCheckedOutBookListAndAddItToAvailableBooksList(indexOfBookToBeReturned);
            return true;
        }
        return false;
    }

    private void removeBookFromCheckedOutBookListAndAddItToAvailableBooksList(int indexOfBookToBeReturned) {
        listOfBooksAvailable.add(listOfCheckedOutBooks.get(indexOfBookToBeReturned));
        listOfCheckedOutBooks.remove(indexOfBookToBeReturned);
    }
}
