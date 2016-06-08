package com.epam.application.command;


import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

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

        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.ADD_BOOK);

        try {

            service.execute(bookName, author, genre, annotation);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
