package com.epam.application.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {

    public String execute(HttpServletRequest request) {

        final String START_PAGE = "/index.jsp";
        HttpSession session = request.getSession(true);
        session.setAttribute("login", "");
        return START_PAGE;
    }
}
