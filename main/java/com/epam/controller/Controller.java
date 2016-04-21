package com.epam.controller;

import com.epam.command.Command;
import com.epam.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandType = req.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(commandType);
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req,resp);

    }
}
