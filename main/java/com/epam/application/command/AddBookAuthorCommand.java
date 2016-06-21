package com.epam.application.command;


import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

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
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.ADD_BOOK_AUTHOR);

        try {

            service.execute(bookId,writerId);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
