package com.epam.library.service.exception;


import com.epam.library.dao.exception.DaoException;

public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {

        super(message,e);
    }

    public ServiceException(DaoException e) {

        super(e);

    }
}
