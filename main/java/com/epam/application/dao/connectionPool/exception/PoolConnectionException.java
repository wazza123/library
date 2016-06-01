package com.epam.application.dao.connectionPool.exception;


public class PoolConnectionException extends Exception {

    public PoolConnectionException(String message,Exception e) {

        super(message,e);
    }
}
