package com.company.library.bean;


import java.util.List;

public class Book {

    private int id;
    private String name;
    private String genre;
    private List<Writer> author;
    private String annotation;
    private String bookFilePath;
    private String bookCoverPath;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public String getAnnotation() {

        return annotation;
    }

    public String getBookFilePath() {

        return bookFilePath;
    }

    public String getBookCoverPath() {

        return bookCoverPath;
    }

    public void setBookCoverPath(String bookCoverPath) {

        this.bookCoverPath = bookCoverPath;
    }

    public void setBookFilePath(String bookFilePath) {

        this.bookFilePath = bookFilePath;
    }

    public void setAnnotation(String annotation) {

        this.annotation = annotation;
    }

    public List<Writer> getAuthor() {
        return author;
    }

    public void setAuthor(List<Writer> author) {
        this.author = author;
    }
}
