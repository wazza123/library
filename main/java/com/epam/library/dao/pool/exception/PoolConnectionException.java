package com.epam.library.dao.pool.exception;


public class PoolConnectionException extends Exception {

    public PoolConnectionException(String message,Exception e) {

        super(message,e);
    }
}
