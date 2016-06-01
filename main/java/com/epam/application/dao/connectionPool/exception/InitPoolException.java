package com.epam.application.dao.connectionPool.exception;


public class InitPoolException extends Exception {

    public InitPoolException(String message, Exception e) {

        super(message,e);
    }
}
