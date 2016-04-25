package com.epam.application.command;


import com.epam.application.bean.Account;
import com.epam.application.command.exception.CommandException;
import com.epam.application.dao.AccountDAO;
import com.epam.application.dao.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginValidationCommand implements Command {

    public String execute(HttpServletRequest request) throws CommandException {

        final String LOGIN_PAGE = "WEB-INF/login.jsp";
        final String ERROR_PAGE = "WEB-INF/error.jsp";
        AccountDAO accountDAO = new AccountDAO();
        String enteredLogin = request.getParameter("login");
        String enteredPassword = request.getParameter("password");
        Account account = new Account();

        account.setLogin(enteredLogin);
        account.setPassword(enteredPassword);

        try {

            if (account.equals(accountDAO.getAccount(enteredLogin))) {

                HttpSession session = request.getSession(true);
                session.setAttribute("login", session.getId());
                session.setMaxInactiveInterval(-1);

                return LOGIN_PAGE;
            }
            else {

                return ERROR_PAGE;
            }
        }
        catch (DaoException e) {

            throw new CommandException(e);
        }
    }
}
