package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class BookInfoService implements Service {

    public boolean execute(Object... params) throws ServiceException {

        return false;
    }

    public Object getInformation(Object... params) throws ServiceException {

        Integer bookId =  Integer.valueOf((Integer) params[0]);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOk_DAO);
        Book book;

        try {

            book = bookDAO.getBookById(bookId);
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return book;
    }
}
