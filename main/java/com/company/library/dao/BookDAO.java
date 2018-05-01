package com.company.library.dao;


import com.company.library.bean.Writer;
import com.company.library.dao.exception.DaoException;
import com.company.library.bean.Book;

import java.util.List;

public interface BookDAO extends Dao {

    public Book getBookById(int id) throws DaoException;

    public List<Book> getBooksByName(String name) throws DaoException;

    public List<Book> getBooksByGenre(String genre) throws DaoException;

    public List<Book> getBooksByAuthor(Writer author) throws DaoException;

    public List<Book> getAllBooks() throws DaoException;

    public void addBook(Book book) throws DaoException;

    public void deleteBook(int BookId) throws DaoException;

    public void addAuthor(int writerId, int bookId) throws DaoException;
}
