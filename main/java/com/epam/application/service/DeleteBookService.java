package com.epam.application.service;


import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class DeleteBookService implements Service {

    public Object execute(Object... params) throws ServiceException {

        int bookId = Integer.valueOf((String) params[0]);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);

        try {

            bookDAO.deleteBook(bookId);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
