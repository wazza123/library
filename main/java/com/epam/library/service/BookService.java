package com.epam.library.service;


import com.epam.library.bean.Book;
import com.epam.library.bean.Writer;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public interface BookService extends Service {

    public boolean addBook(Book book) throws ServiceException;

    public boolean deleteBook(int bookId) throws ServiceException;

    public List<Book> findBook(Book book) throws ServiceException;

    public Book getBook(int bookId) throws ServiceException;

    public List<Book> getBooksByCategory(String category) throws ServiceException;

    public boolean addBookAuthor(int writerId, int bookId) throws ServiceException;
}
