package com.epam.library.command;


import com.epam.library.bean.Book;
import com.epam.library.command.exception.CommandException;
import com.epam.library.service.BookService;
import com.epam.library.service.Service;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class AddBookCommand implements Command {

    private final String PAGE = "WEB-INF/adminMainPage.jsp";
    private final String BOOK_NAME_ATTRIBUTE = "book_name";
    private final String AUTHOR_ATTRIBUTE = "author";
    private final String GENRE_ATTRIBUTE = "genre";
    private final String ANNOTATION_ATTRIBUTE = "annotation";
    private final String BOOK_FILE_ATTRIBUTE = "book_file";

    public String execute(HttpServletRequest request) throws CommandException {

        String bookName = request.getParameter(BOOK_NAME_ATTRIBUTE);
        String author = request.getParameter(AUTHOR_ATTRIBUTE);
        String genre = request.getParameter(GENRE_ATTRIBUTE);
        String annotation = request.getParameter(ANNOTATION_ATTRIBUTE);
        String bookFile = request.getParameter(BOOK_FILE_ATTRIBUTE);
        Book book = new Book();

        book.setName(bookName);
        book.setGenre(genre);
        book.setAnnotation(annotation);
        book.setBookFilePath(bookFile);

        try {

            ServiceFactory serviceFactory = ServiceFactory.getFactory();
            BookService service = (BookService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_BOOK_SERVICE);
            service.addBook(book);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
