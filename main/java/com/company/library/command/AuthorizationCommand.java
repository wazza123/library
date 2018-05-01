package com.company.library.command;


import com.company.library.bean.Account;
import com.company.library.command.exception.CommandException;
import com.company.library.service.ServiceFactory;
import com.company.library.service.AccountService;
import com.company.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationCommand implements Command {

    private final String AUTHORIZATION_PAGE = "authorization.jsp";
    private final String LOGIN_PAGE = "WEB-INF/login.jsp";
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
        AccountService service = (AccountService) serviceFactory.getService(ServiceFactory.ServiceType.DAO_ACCOUNT_SERVICE);
        Account account = new Account();

        account.setLogin(enteredLogin);
        account.setPassword(enteredPassword);

        try {

            if (service.authorize(account)) {

                if (service.getAccount(enteredLogin).getRole().equals(USER_ROLE)) {

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
