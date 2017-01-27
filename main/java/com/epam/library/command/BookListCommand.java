package com.epam.library.command;


import com.epam.library.bean.Book;
import com.epam.library.command.exception.CommandException;
import com.epam.library.service.BookService;
import com.epam.library.service.Service;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BookListCommand implements Command {

    private final String BOOK_TYPE_ATTRIBUTE = "book_type";
    private final String BOOK_LIST_ATTRIBUTE = "books";
    private final String PAGE = "WEB-INF/bookList.jsp";

    public String execute(HttpServletRequest request) throws CommandException {

        String bookCategory = request.getParameter(BOOK_TYPE_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        BookService service = (BookService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_BOOK_SERVICE);
        List<Book> books;

        try {

           books = service.getBooksByCategory(bookCategory);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        request.setAttribute(BOOK_LIST_ATTRIBUTE,books);
        return PAGE;
    }
}
