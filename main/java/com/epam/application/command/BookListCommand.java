package com.epam.application.command;


import com.epam.application.bean.Book;
import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BookListCommand implements Command {

    private final String BOOK_TYPE_ATTRIBUTE = "book_type";
    private final String BOOK_LIST_ATTRIBUTE = "books";
    private final String PAGE = "WEB-INF/bookList.jsp";

    public String execute(HttpServletRequest request) throws CommandException {

        String bookCategory = request.getParameter(BOOK_TYPE_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.BOOK_LIST);
        List<Book> books;

        try {

           books = (List<Book>) service.execute(bookCategory);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        request.setAttribute(BOOK_LIST_ATTRIBUTE,books);
        return PAGE;
    }
}
