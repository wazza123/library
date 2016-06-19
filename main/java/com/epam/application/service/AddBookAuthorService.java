package com.epam.application.service;


import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class AddBookAuthorService implements Service {

    public Object execute(Object... params) throws ServiceException {

        int bookId =  Integer.valueOf((Integer) params[0]);
        int writerId = Integer.valueOf((Integer) params[1]);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);

        try {

            bookDAO.addAuthor(writerId,bookId);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
