package com.epam.application.command;


import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AddWriterCommand implements Command {

    private final String PAGE = "WEB-INF/adminMainPage.jsp";
    private final String FIRST_NAME_ATTRIBUTE = "first_name";
    private final String LAST_NAME_ATTRIBUTE = "last_name";

    public String execute(HttpServletRequest request) throws CommandException {

        String firstName = request.getParameter(FIRST_NAME_ATTRIBUTE);
        String lastName = request.getParameter(LAST_NAME_ATTRIBUTE);
        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.ADD_WRITER);

        try {

            service.execute(firstName, lastName);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
