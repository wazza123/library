package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class BookInfoService implements Service {

    public Object execute(Object... params) throws ServiceException {

        Integer bookId =  Integer.valueOf((Integer) params[0]);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        Book book;
        Writer writer;

        try {

            book = bookDAO.getBookById(bookId);
            writer = writerDao.getWriterByBook(book.getId());
            book.setAuthor(writer);
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return book;
    }
}
