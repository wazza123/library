package com.epam.library.service;

import com.epam.library.bean.Writer;
import com.epam.library.dao.BookDAO;
import com.epam.library.dao.DaoFactory;
import com.epam.library.dao.WriterDao;
import com.epam.library.dao.exception.DaoException;
import com.epam.library.service.exception.ServiceException;

import java.util.List;


public class DaoWriterService implements WriterService {

    public boolean addWriter(Writer writer) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);

        try {

            writerDao.addWriter(writer);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }

    public boolean findWriter(Writer writer) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);

        try {

            writerDao.getWritersByName(writer.getFirstName(), writer.getLastName());
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }

    public Writer getWriter(int writerId) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        Writer writer;

        try {

            writer = writerDao.getWriterById(writerId);
            writer.setBooks(bookDAO.getBooksByAuthor(writer));
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return writer;
    }

    public List<Writer> getWriters(Writer writer) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);

        try {

            return writerDao.getWritersByName(writer.getFirstName(), writer.getLastName());
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
