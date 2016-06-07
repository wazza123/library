package com.epam.application.command;


import com.epam.application.bean.Book;
import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindBookCommand implements Command {

    private final String BOOK_NAME_ATTRIBUTE = "book_title";
    private final String BOOK_LIST_ATTRIBUTE = "books";
    private final String PAGE_ATTRIBUTE = "page";
    private final String PAGE = "WEB-INF/bookList.jsp";
    private final String ADMIN_BOOK_LIST_PAGE = "WEB-INF/deleteBookList.jsp";
    private final String USER_ROLE_ATTRIBUTE = "role";
    private final String USER_ROLE = "user";
    private final String ADMIN_ROLE = "admin";

    public String execute(HttpServletRequest request) throws CommandException {


        String bookName = request.getParameter(BOOK_NAME_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.FIND_BOOK);
        String userRole = null;
        HttpSession session = request.getSession(false);
        List<Book> books;

        if (session != null) {

            userRole = (String) session.getAttribute(USER_ROLE_ATTRIBUTE);
        }


        try {

            books = (List<Book>) service.getInformation(bookName);
            request.setAttribute(BOOK_LIST_ATTRIBUTE,books);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        if (userRole == null) {

            return PAGE;
        }
        else if (userRole.equals(USER_ROLE)) {

            return PAGE;
        }
        else {

            return ADMIN_BOOK_LIST_PAGE;
        }
    }
}
