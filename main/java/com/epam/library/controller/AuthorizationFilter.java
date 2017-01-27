package com.epam.library.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private final String START_PAGE = "/index.jsp";
    private final String LOGIN_PAGE = "WEB-INF/login.jsp";
    private final String ADMIN_MAIN_PAGE = "WEB-INF/adminMainPage.jsp";
    private final String USER_ROLE_ATTRIBUTE = "role";
    private final String USER_ROLE = "user";

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(false);
        String page;

        if (session != null) {

         if (session.getAttribute(USER_ROLE_ATTRIBUTE).equals(USER_ROLE)) {

                page = LOGIN_PAGE;
            }
            else {

                page = ADMIN_MAIN_PAGE;
            }

            servletRequest.getRequestDispatcher(page).forward(servletRequest, servletResponse);
        }
        else {

            servletRequest.getRequestDispatcher(START_PAGE).forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
