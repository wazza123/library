package com.epam.application.dao.exception;


public class DaoException extends Exception {

    public DaoException(Exception e) {

    }

    public DaoException(String message, ClassNotFoundException e) {

        super(message,e);
    }
}
