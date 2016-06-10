package com.epam.application.service;


import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class WriterInfoService implements Service {

    public Object execute(Object... params) throws ServiceException {

        Integer writerId =  Integer.valueOf((Integer) params[0]);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        Writer writer;

        try {

            writer = writerDao.getWriterById(writerId);
            writer.setBooks(bookDAO.getBooksByAuthor(writer.toString()));
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return writer;
    }
}
