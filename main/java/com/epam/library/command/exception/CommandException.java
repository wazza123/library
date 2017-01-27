package com.epam.library.command.exception;


import com.epam.library.service.exception.ServiceException;

public class CommandException extends Exception {
    public CommandException(Exception e) {

        super(e);
    }

    public CommandException(String s, ServiceException e) {

    }
}
