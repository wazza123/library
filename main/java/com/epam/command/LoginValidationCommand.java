package com.epam.command;


import com.epam.dao.AccountDAO;

import javax.servlet.http.HttpServletRequest;

public class LoginValidationCommand implements Command {

    public String execute(HttpServletRequest request) {

        AccountDAO accountDAO = new AccountDAO();
        String login = accountDAO.getLogin(request.getParameter("login"));

        if (login != null) {

            return "WEB-INF/login.jsp";
        }
        else {

            return "WEB-INF/error.jsp";
        }

    }
}
