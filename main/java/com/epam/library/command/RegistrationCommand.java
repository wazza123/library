package com.epam.library.command;


import com.epam.library.bean.Account;
import com.epam.library.command.exception.CommandException;
import com.epam.library.service.AccountService;
import com.epam.library.service.Service;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

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
        AccountService service = (AccountService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_ACCOUNT_SERVICE);
        HttpSession session = request.getSession(true);
        String login = request.getParameter(LOGIN_ATTRIBUTE);
        String password = request.getParameter(PASSWORD_ATTRIBUTE);
        Account account = new Account();

        account.setLogin(login);
        account.setPassword(password);

        try {

            if((Boolean)service.registrate(account)) {

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

