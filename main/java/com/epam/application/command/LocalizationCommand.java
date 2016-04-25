package com.epam.application.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocalizationCommand implements Command {

    public String execute(HttpServletRequest request) {

        final String LAST_PAGE_ATTRIBUTE_NAME = "page";
        final String LOCALE_ATTRIBUTE_NAME = "locale";
        String localeParameters = request.getParameter("local");
        String language = localeParameters;

        HttpSession session = request.getSession(true);
        String page = String.valueOf(session.getAttribute(LAST_PAGE_ATTRIBUTE_NAME));
        session.setAttribute(LOCALE_ATTRIBUTE_NAME, language);

        return page;
    }
}
