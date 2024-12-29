/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import enums.State;

/**
 *
 * @author DELL
 */




public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private State state;
    private int year;

    public Book(String isbn, String title, String author, String genre, State state, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.state = state;
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        // return "Book{ISBN='" + isbn + "', title='" + title + "', author='" + author + "', genre='" + genre + "', state='" + state + "', year=" + year + "}";
        return "" + isbn + ", " + title + ", " + author + ", " + genre + ", " + state + ", " + year;
    }
}




