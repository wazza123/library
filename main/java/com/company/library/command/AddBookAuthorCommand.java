package com.company.library.command;


import com.company.library.bean.Book;
import com.company.library.command.exception.CommandException;
import com.company.library.service.BookService;
import com.company.library.service.ServiceFactory;
import com.company.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AddBookAuthorCommand implements Command {

    private final String PAGE = "WEB-INF/adminMainPage.jsp";
    private final String BOOK_ID_ATTRIBUTE = "book_id";
    private final String WRITER_ID_ATTRIBUTE = "writer_id";
    private final String AUTHOR_FIRST_NAME_ATTRIBUTE = "first_name";
    private final String AUTHOR_LAST_NAME_ATTRIBUTE = "last_name";

    public String execute(HttpServletRequest request) throws CommandException {

        int bookId = Integer.parseInt(request.getParameter(BOOK_ID_ATTRIBUTE));
        int writerId = Integer.parseInt(request.getParameter(WRITER_ID_ATTRIBUTE));

        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        BookService service = (BookService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_BOOK_SERVICE);

        try {

            Book book = new Book();
            book.setId(bookId);
            service.addBookAuthor(bookId,writerId);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
