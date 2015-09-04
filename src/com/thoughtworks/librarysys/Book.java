package com.thoughtworks.librarysys;

public class Book {
    private String name;
    private String author;
    private int yearOfPublication;

    public Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return this.name+"\t"+this.author+"\t"+yearOfPublication+"\n";
    }
}
