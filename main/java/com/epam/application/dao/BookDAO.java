package com.epam.application.dao;


import com.epam.application.bean.Book;
import com.epam.application.dao.exception.DaoException;

import java.util.List;

public interface BookDAO extends Dao {

    public Book getBookById(int id) throws DaoException;

    public List<Book> getBooksByName(String name) throws DaoException;

    public List<Book> getBooksByGenre(String genre) throws DaoException;

    public List<Book> getBooksByAuthor(String author);

    public List<Book> getAllBooks() throws DaoException;

    public void addBook(Book book) throws DaoException;

    public void deleteBook(int BookId) throws DaoException;
}
