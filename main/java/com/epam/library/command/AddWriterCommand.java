package com.epam.library.command;


import com.epam.library.bean.Writer;
import com.epam.library.command.exception.CommandException;
import com.epam.library.service.Service;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.WriterService;
import com.epam.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AddWriterCommand implements Command {

    private final String PAGE = "WEB-INF/adminMainPage.jsp";
    private final String FIRST_NAME_ATTRIBUTE = "first_name";
    private final String LAST_NAME_ATTRIBUTE = "last_name";

    public String execute(HttpServletRequest request) throws CommandException {

        String firstName = request.getParameter(FIRST_NAME_ATTRIBUTE);
        String lastName = request.getParameter(LAST_NAME_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        WriterService service = (WriterService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_WRITER_SERVICE);
        Writer writer = new Writer();

        writer.setFirstName(firstName);
        writer.setLastName(lastName);

        try {

            service.addWriter(writer);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
