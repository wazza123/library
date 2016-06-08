package com.epam.application.command;


import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {

    final String PAGE = "WEB-INF/login.jsp";
    private final String REGISTRATION_PAGE = "registration.jsp";
    final String LOGIN_ATTRIBUTE = "login";
    final String PASSWORD_ATTRIBUTE = "password";
    private final String ERROR_MESSAGE_ATTRIBUTE = "error_message";
    private final String ERROR_MESSAGE = "this login is already used!";
    private final String USER_ROLE_ATTRIBUTE = "role";
    private final String USER_ROLE = "user";

    public String execute(HttpServletRequest request) throws CommandException {

        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.REGISTRATION);
        HttpSession session = request.getSession(true);
        String login = request.getParameter(LOGIN_ATTRIBUTE);
        String password = request.getParameter(PASSWORD_ATTRIBUTE);

        try {

            if((Boolean)service.execute(login, password)) {

                session.setAttribute(USER_ROLE_ATTRIBUTE,USER_ROLE);
                return PAGE;
            }

            else {

                request.setAttribute(ERROR_MESSAGE_ATTRIBUTE,ERROR_MESSAGE);
                return REGISTRATION_PAGE;
            }
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

    }
}

