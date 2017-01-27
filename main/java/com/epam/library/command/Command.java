package com.epam.library.command;


import com.epam.library.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    public String execute(HttpServletRequest request) throws CommandException;
}
