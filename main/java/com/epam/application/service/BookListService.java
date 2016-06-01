package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

import java.util.List;

public class BookListService implements Service {

    private final String ALL_BOOK_CATEGORIES = "all";

    public boolean execute(Object... params) throws ServiceException {

        return false;
    }

    public Object getInformation(Object... params) throws ServiceException {

        String bookCategory = (String) params[0];
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOk_DAO);
        List<Book> books;

        try {

            if (bookCategory.equals(ALL_BOOK_CATEGORIES)) {

                books = bookDAO.getAllBooks();
            }
            else {

               books = bookDAO.getBooksByGenre(bookCategory);
            }
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return books;
    }
}
