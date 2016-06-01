package com.epam.application.command;


import com.epam.application.bean.Book;
import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class BookInfoCommand implements Command {

    private final String INFO_PAGE = "WEB-INF/info.jsp";
    private final String ERROR_PAGE = "";
    private final String BOOK_ID_ATTRIBUTE = "book_id";

    public String execute(HttpServletRequest request) throws CommandException {

        Integer bookId = Integer.valueOf(request.getParameter(BOOK_ID_ATTRIBUTE));
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.BOOK_INFO);
        String page;
        Book book;

        try {

            book = (Book) service.getInformation(bookId);
            page = INFO_PAGE;
        }
        catch (ServiceException e) {

            page = ERROR_PAGE;
            throw new CommandException(e);
        }

        request.setAttribute("book_info",book);
        return page;
    }
}
