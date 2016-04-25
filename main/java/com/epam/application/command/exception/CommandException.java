package com.epam.application.command.exception;


public class CommandException extends Exception {
    public CommandException(Exception e) {

        super(e);
    }
}
