package com.epam.application.bean;


import java.util.List;

public class Writer {

    private int id;
    private String firstName;
    private String lastName;
    private List<Book> books;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    @Override
    public String toString() {

        return firstName + " " + lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
