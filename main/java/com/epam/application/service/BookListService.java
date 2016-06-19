package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

import java.util.List;

public class BookListService implements Service {

    private final String ALL_BOOK_CATEGORIES = "all";

    public Object execute(Object... params) throws ServiceException {

        String bookCategory = (String) params[0];
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        List<Book> books;
        List<Writer> writers;

        try {

            if (bookCategory.equals(ALL_BOOK_CATEGORIES)) {

                books = bookDAO.getAllBooks();
            }
            else {

               books = bookDAO.getBooksByGenre(bookCategory);
            }

            for (int i = 0; i < books.size(); i++) {

                writers = writerDao.getWritersByBook(books.get(i).getId());
                books.get(i).setAuthor(writers);
            }
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }

        return books;
    }
}
