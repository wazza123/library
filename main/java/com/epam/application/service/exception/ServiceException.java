package com.epam.application.service.exception;


import com.epam.application.dao.exception.DaoException;

public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {

        super(message,e);
    }

    public ServiceException(DaoException e) {

        super(e);

    }
}
