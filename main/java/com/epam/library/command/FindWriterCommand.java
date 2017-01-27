package com.epam.library.command;


import com.epam.library.bean.Writer;
import com.epam.library.command.exception.CommandException;
import com.epam.library.service.Service;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.WriterService;
import com.epam.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindWriterCommand implements Command {

    private final String AUTHOR_FIRST_NAME_ATTRIBUTE = "first_name";
    private final String AUTHOR_LAST_NAME_ATTRIBUTE = "last_name";
    private final String WRITER_LIST_ATTRIBUTE = "writers";
    private final String BOOK_ID_ATTRIBUTE = "book_id";
    private final String PAGE = "WEB-INF/writerList.jsp";

    public String execute(HttpServletRequest request) throws CommandException {

        int bookId = Integer.parseInt(request.getParameter("book_id"));
        String firstName = request.getParameter(AUTHOR_FIRST_NAME_ATTRIBUTE);
        String lastName = request.getParameter(AUTHOR_LAST_NAME_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        WriterService service = (WriterService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_WRITER_SERVICE);
        List<Writer> writers;
        Writer writer = new Writer();

        writer.setFirstName(firstName);
        writer.setLastName(lastName);

        try {

            writers = service.getWriters(writer);
            request.setAttribute(WRITER_LIST_ATTRIBUTE,writers);
            request.setAttribute(BOOK_ID_ATTRIBUTE,bookId);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
