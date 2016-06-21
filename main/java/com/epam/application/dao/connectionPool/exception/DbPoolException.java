package com.epam.application.dao.connectionPool.exception;


public class DbPoolException extends Exception {

    public DbPoolException(Exception e) {

        super(e);
    }
}
