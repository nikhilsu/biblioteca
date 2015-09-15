package com.thoughtworks.librarysys;

//Movie contains the name year of release director and the rating and returns the same in a formatted way
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

    public String displayDetails() {
        return String.format("%-25s%-20s%-30s%-20s\n", this.name, this.year, this.director, this.rating);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Movie that = (Movie) obj;
        if (this.name.equals(that.name))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + year;
        result = 31 * result + director.hashCode();
        result = 31 * result + rating;
        return result;
    }
}
