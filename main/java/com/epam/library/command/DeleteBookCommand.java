package com.epam.library.command;


import com.epam.library.command.exception.CommandException;
import com.epam.library.service.BookService;
import com.epam.library.service.Service;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class DeleteBookCommand implements Command {

    private final String PAGE = "WEB-INF/adminMainPage.jsp";
    private final String BOOK_ID_ATTRIBUTE = "book_id";

    public String execute(HttpServletRequest request) throws CommandException {

        int bookId = Integer.parseInt(request.getParameter(BOOK_ID_ATTRIBUTE));
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        BookService service = (BookService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_BOOK_SERVICE);

        try {

            service.deleteBook(bookId);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
