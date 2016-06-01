package com.epam.application.bean;


public class Book {

    private int id;
    private String name;
    private String genre;
    private Writer author;
    private String annotation;
    private String publisher;
    private String bookFilePath;

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

    public Writer getAuthor() {

        return author;
    }

    public void setAuthor(Writer author) {

        this.author = author;
    }

    public String getAnnotation() {

        return annotation;
    }

    public String getPublisher() {

        return publisher;
    }

    public void setPublisher(String publisher) {

        this.publisher = publisher;
    }

    public String getBookFilePath() {

        return bookFilePath;
    }

    public void setBookFilePath(String bookFilePath) {

        this.bookFilePath = bookFilePath;
    }

    public void setAnnotation(String annotation) {

        this.annotation = annotation;
    }

    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + author.hashCode();
        result = prime * result + genre.hashCode();
        result = prime * result + annotation.hashCode();
        return result;
    }

    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }
        if (obj == null) {

            return false;
        }
        if (getClass() != obj.getClass()) {

            return false;
        }

        Book other = (Book) obj;

        if (!name.equals(other.getName())) {

            return false;
        }
        if (!author.equals(other.getAuthor())) {

            return false;
        }
        if (!genre.equals(other.getGenre())) {

            return false;
        }
        if (!annotation.equals(other.getAnnotation())) {

            return false;
        }

        return true;
    }
}
