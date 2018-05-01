package com.company.library.command;


import com.company.library.bean.Writer;
import com.company.library.command.exception.CommandException;
import com.company.library.service.ServiceFactory;
import com.company.library.service.WriterService;
import com.company.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class WriterInfoCommand implements Command {

    private final String INFO_PAGE = "WEB-INF/writerInfo.jsp";
    private final String AUTHOR_ID_ATTRIBUTE = "author_id";
    private final String AUTHOR_ATTRIBUTE = "author";
    private final String BOOKS_ATTRIBUTE = "books";
    private final String AUTHORIZATION_STATUS_ATTRIBUTE = "isAuthorized";

    public String execute(HttpServletRequest request) throws CommandException {

        Integer writerId = Integer.valueOf(request.getParameter(AUTHOR_ID_ATTRIBUTE));
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        WriterService service = (WriterService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_WRITER_SERVICE);
        String page;
        Writer writer;

        try {

            writer = service.getWriter(writerId);
            page = INFO_PAGE;
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        request.setAttribute(BOOKS_ATTRIBUTE, (List) writer.getBooks());
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
