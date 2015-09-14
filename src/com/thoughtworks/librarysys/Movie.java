package com.thoughtworks.librarysys;

public class Movie {
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

    @Override
    public String toString() {
        return String.format("%-30s%-20s%-35s%-20s\n", this.name, this.year, this.director, this.rating);
    }

}
