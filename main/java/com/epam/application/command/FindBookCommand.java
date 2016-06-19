package com.epam.application.command;


import com.epam.application.bean.Book;
import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindBookCommand implements Command {

    private final String BOOK_NAME_ATTRIBUTE = "book_title";
    private final String BOOK_LIST_ATTRIBUTE = "books";
    private final String PAGE = "WEB-INF/bookList.jsp";

    public String execute(HttpServletRequest request) throws CommandException {

        String bookName = request.getParameter(BOOK_NAME_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.FIND_BOOK);
        List<Book> books;

        try {

            books = (List<Book>) service.execute(bookName);
            request.setAttribute(BOOK_LIST_ATTRIBUTE,books);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
