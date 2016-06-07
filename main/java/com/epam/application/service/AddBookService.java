package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;


public class AddBookService implements Service {

    private final String BOOK_FILE_DIRECTORY = "D:\\erp\\";

    public Object getInformation(Object... params) throws ServiceException {

        String bookName = (String) params[0];
        String author = (String) params[1];
        String genre = (String) params[2];
        String annotation = (String) params[3];

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        BookDAO bookDAO = (BookDAO) daoFactory.getDao(DaoFactory.DaoType.DB_BOOk_DAO);
        Book book = new Book();
        Writer writer = new Writer();

        writer.setFirstName(author);
        writer.setLastName("");
        book.setName(bookName);
        book.setAuthor(writer);
        book.setGenre(genre);
        book.setAnnotation(annotation);
        book.setBookFilePath(BOOK_FILE_DIRECTORY + bookName);

        try {

            bookDAO.addBook(book);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
