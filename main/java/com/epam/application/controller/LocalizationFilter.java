package com.epam.application.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LocalizationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final String LOCALE_ATTRIBUTE_NAME = "locale";
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(true);

        if (session.isNew()) {

            session.setAttribute(LOCALE_ATTRIBUTE_NAME, httpServletRequest.getLocale().getLanguage());
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
