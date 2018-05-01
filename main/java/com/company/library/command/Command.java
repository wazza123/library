package com.company.library.command;


import com.company.library.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    public String execute(HttpServletRequest request) throws CommandException;
}
