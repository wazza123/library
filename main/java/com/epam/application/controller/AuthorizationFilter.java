package com.epam.application.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final String START_PAGE = "/index.jsp";
        final String LOGIN_PAGE = "WEB-INF/login.jsp";
        final String LOCALE_ATTRIBUTE_NAME = "locale";
        final String LAST_PAGE_ATTRIBUTE_NAME = "page";
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(true);

        if (session.isNew()) {

            session.setAttribute(LOCALE_ATTRIBUTE_NAME, httpServletRequest.getLocale().getLanguage());
        }

        if (session.getId().equals(session.getAttribute("login"))) {

            session.setAttribute(LAST_PAGE_ATTRIBUTE_NAME,LOGIN_PAGE);
            servletRequest.getRequestDispatcher(LOGIN_PAGE).forward(servletRequest,servletResponse);
        }
        else {

            session.setAttribute(LAST_PAGE_ATTRIBUTE_NAME,START_PAGE);
            servletRequest.getRequestDispatcher(START_PAGE).forward(servletRequest,servletResponse);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
