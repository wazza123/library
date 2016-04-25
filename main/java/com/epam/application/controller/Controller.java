package com.epam.application.controller;

import com.epam.application.command.Command;
import com.epam.application.command.CommandFactory;
import com.epam.application.command.exception.CommandException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger LOGGER = Logger.getRootLogger();
        final String LAST_PAGE_ATTRIBUTE_NAME = "page";

        String commandType = req.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(commandType);
        String page = null;

        try {

            page = command.execute(req);
        }
        catch (CommandException e) {

            LOGGER.error(e.getMessage(), e);
        }

        req.getSession(true).setAttribute(LAST_PAGE_ATTRIBUTE_NAME,page);
        req.getRequestDispatcher(page).forward(req,resp);
    }
}
