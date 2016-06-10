package com.epam.application.command;


import com.epam.application.bean.Writer;
import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class WriterInfoCommand implements Command {

    private final String INFO_PAGE = "WEB-INF/writerInfo.jsp";
    private final String AUTHOR_ID_ATTRIBUTE = "author_id";
    private final String AUTHOR_ATTRIBUTE = "author";
    private final String BOOKS_ATTRIBUTE = "book_info";
    private final String AUTHORIZATION_STATUS_ATTRIBUTE = "isAuthorized";

    public String execute(HttpServletRequest request) throws CommandException {

        Integer writerId = Integer.valueOf(request.getParameter(AUTHOR_ID_ATTRIBUTE));
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.WRITER_INFO);
        String page;
        Writer writer;

        try {

            writer = (Writer) service.execute(writerId);
            page = INFO_PAGE;
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        request.setAttribute(BOOKS_ATTRIBUTE,writer.getBooks());
        request.setAttribute(AUTHOR_ATTRIBUTE,writer);

        if (request.getSession(false) == null) {

            request.setAttribute(AUTHORIZATION_STATUS_ATTRIBUTE, false);
        }
        else {

            request.setAttribute(AUTHORIZATION_STATUS_ATTRIBUTE,true);
        }
        return page;
    }
}
