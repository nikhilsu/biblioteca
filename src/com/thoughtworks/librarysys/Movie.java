package com.thoughtworks.librarysys;

//Movie contains the name year of release director and the rating and returns the same in a formatted way
public class Movie implements LibraryItem{
    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String displayDetails() {
        return String.format("%-25s%-20s%-30s%-20s\n", this.name, this.year, this.director, this.rating);
    }
}
