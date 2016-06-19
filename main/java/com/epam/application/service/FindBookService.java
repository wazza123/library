package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

import java.util.List;

public class FindBookService implements Service {

    public Object execute(Object... params) throws ServiceException {

        String bookNaMe = (String) params[0];
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        List<Book> books;
        List<Writer> writers;

        try {

            books =  bookDAO.getBooksByName(bookNaMe);

            for (int i = 0; i < books.size(); i++) {

                writers = writerDao.getWritersByBook(books.get(i).getId());
                books.get(i).setAuthor(writers);
            }

           return books;
        }

        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
