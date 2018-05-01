package com.company.library.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {

    private final String START_PAGE = "/index.jsp";

    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        session.invalidate();
        return START_PAGE;
    }
}
