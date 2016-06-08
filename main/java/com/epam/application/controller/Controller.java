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

    final Logger LOGGER = Logger.getRootLogger();
    final String COMMAND_PARAMETER_NAME = "command";
    final String ERROR_PAGE = "WEB-INF/errorPage.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandType = req.getParameter(COMMAND_PARAMETER_NAME);
        CommandFactory commandFactory = CommandFactory.getFactory();
        Command command = commandFactory.getCommand(commandType);
        String page = null;

        try {

            page = command.execute(req);
        }
        catch (CommandException e) {

            LOGGER.error("exception occur",e);
            page = ERROR_PAGE;
        }

        req.getRequestDispatcher(page).forward(req,resp);
    }


}
