package com.epam.application.command;


import com.epam.application.bean.Account;
import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationCommand implements Command {

    private final static Logger LOGGER = Logger.getRootLogger();
    private final String AUTHORIZATION_PAGE = "authorization.jsp";
    private final String LOGIN_PAGE = "WEB-INF/login.jsp";
    private final String ERROR_PAGE = "WEB-INF/error.jsp";
    private final String LOGIN_ATTRIBUTE_NAME = "login";
    private final String ADMIN_MAIN_PAGE = "WEB-INF/adminMainPage.jsp";
    private final String PASSWORD_ATTRIBUTE_NAME = "password";
    private final String ERROR_MESSAGE_ATTRIBUTE = "error_message";
    private final String ERROR_MESSAGE = "incorrect login or password!";
    private final String USER_ROLE_ATTRIBUTE = "role";
    private final String USER_ROLE = "user";
    private final String ADMIN_ROLE = "admin";

    public String execute(HttpServletRequest request) throws CommandException {

        String enteredLogin = request.getParameter(LOGIN_ATTRIBUTE_NAME);
        String enteredPassword = request.getParameter(PASSWORD_ATTRIBUTE_NAME);

        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.AUTHORIZATION);

        try {
        Account account = (Account) service.getInformation(enteredLogin,enteredPassword);

            if (account != null) {

                if (account.getRole().equals(USER_ROLE)) {

                    request.getSession().setAttribute(USER_ROLE_ATTRIBUTE,USER_ROLE);
                    return LOGIN_PAGE;
                }
                else {

                    request.getSession().setAttribute(USER_ROLE_ATTRIBUTE,ADMIN_ROLE);
                    return ADMIN_MAIN_PAGE;
                }
            }
            else {

                request.setAttribute(ERROR_MESSAGE_ATTRIBUTE,ERROR_MESSAGE);
                return AUTHORIZATION_PAGE;
            }
        }
        catch (ServiceException e) {

            throw new CommandException("command error",e);
        }

    }
}
