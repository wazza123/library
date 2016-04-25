package com.epam.application.command;


import com.epam.application.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    public String execute(HttpServletRequest request) throws CommandException;
}
