package com.company.library.service.exception;


import com.company.library.dao.exception.DaoException;

public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {

        super(message,e);
    }

    public ServiceException(DaoException e) {

        super(e);

    }
}
