package com.epam.application.dao.connectionPool;


import com.epam.application.dao.connectionPool.exception.InitPoolException;
import com.epam.application.dao.connectionPool.exception.PoolConnectionException;
import com.epam.application.dao.connectionPool.exception.PoolNotInitException;
import com.epam.application.dao.connectionPool.exception.PropertyNotSetException;

public interface ConnectionPool<E> {

    public void initPool(PoolProperties poolProperties) throws InitPoolException, PropertyNotSetException;

    public E getConnection() throws PoolNotInitException, PoolConnectionException;

    public void retrieveConnection(E connection) throws PoolConnectionException;

    public void cleanPool();

    public int freeConnections();

    public int size();

}
