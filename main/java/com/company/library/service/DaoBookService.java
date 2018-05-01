package com.company.library.service;

import com.company.library.bean.Writer;
import com.company.library.dao.DaoFactory;
import com.company.library.dao.exception.DaoException;
import com.company.library.bean.Book;
import com.company.library.dao.BookDAO;
import com.company.library.dao.WriterDao;
import com.company.library.service.exception.ServiceException;

import java.util.List;


public class DaoBookService implements BookService {

    private final String ALL_BOOK_CATEGORIES = "all";

    public boolean addBook(Book book) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);

        try {

            bookDAO.addBook(book);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }

    public boolean deleteBook(int bookId) throws ServiceException {

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

    public List<Book> findBook(Book book) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        List<Book> books;
        List<Writer> writers;

        try {

            books =  bookDAO.getBooksByName(book.getName());

            for (Book bk : books) {

                writers = writerDao.getWritersByBook(bk.getId());
                bk.setAuthor(writers);
            }

            return books;
        }

        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }

    public Book getBook(int bookId) throws ServiceException {

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

    public List<Book> getBooksByCategory(String bookCategory) throws ServiceException {

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

    public boolean addBookAuthor(int writerId, int bookId) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOK_DAO);

        try {

            bookDAO.addAuthor(writerId,bookId);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
