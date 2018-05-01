package com.company.library.command;


import com.company.library.command.exception.CommandException;
import com.company.library.service.ServiceFactory;
import com.company.library.bean.Book;
import com.company.library.service.BookService;
import com.company.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class BookInfoCommand implements Command {

    private final String INFO_PAGE = "WEB-INF/info.jsp";
    private final String ADMIN_INFO_PAGE = "WEB-INF/adminBookInfo.jsp";
    private final String BOOK_ID_ATTRIBUTE = "book_id";
    private final String AUTHOR_ATTRIBUTE = "author";
    private final String BOOK_INFO_ATTRIBUTE = "book_info";
    private final String AUTHORIZATION_STATUS_ATTRIBUTE = "isAuthorized";

    public String execute(HttpServletRequest request) throws CommandException {

        Integer bookId = Integer.valueOf(request.getParameter(BOOK_ID_ATTRIBUTE));
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        BookService service = (BookService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_BOOK_SERVICE);
        String page;
        Book book;

        try {

            book = service.getBook(bookId);
            page = INFO_PAGE;
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        request.setAttribute(BOOK_INFO_ATTRIBUTE,book);
        request.setAttribute(AUTHOR_ATTRIBUTE,book.getAuthor());

        if (request.getSession(false) == null) {

            request.setAttribute(AUTHORIZATION_STATUS_ATTRIBUTE, false);
        }
        else {

            request.setAttribute(AUTHORIZATION_STATUS_ATTRIBUTE,true);

            if (request.getSession(false).getAttribute("role").equals("admin")) {

                page = ADMIN_INFO_PAGE;
            }
        }
        return page;
    }
}
