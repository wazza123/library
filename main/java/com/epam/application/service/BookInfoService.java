package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

import java.util.List;

public class BookInfoService implements Service {

    public Object execute(Object... params) throws ServiceException {

        Integer bookId =  Integer.valueOf((Integer) params[0]);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        Book book;
        Writer writer;
        List<Writer> writerList = null;

        try {

            book = bookDAO.getBookById(bookId);
            writerList = writerDao.getWritersByBook(book.getId());
            book.setAuthor(writerList);
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return book;
    }
}
