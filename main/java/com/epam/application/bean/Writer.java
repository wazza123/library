package com.epam.application.bean;


public class Writer {

    private int id;
    private String firstName;
    private String lastName;
    private String biography;


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

    public String getBiography() {

        return biography;
    }

    public void setBiography(String biography) {

        this.biography = biography;
    }

    @Override
    public String toString() {

        return firstName + " " + lastName;
    }
}
