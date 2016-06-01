package com.epam.application.command.exception;


import com.epam.application.service.exception.ServiceException;

public class CommandException extends Exception {
    public CommandException(Exception e) {

        super(e);
    }

    public CommandException(String s, ServiceException e) {

    }
}
