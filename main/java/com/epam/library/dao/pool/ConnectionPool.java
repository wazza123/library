package com.epam.library.dao.pool;


import com.epam.library.dao.pool.exception.InitPoolException;
import com.epam.library.dao.pool.exception.PoolConnectionException;
import com.epam.library.dao.pool.exception.PoolNotInitException;
import com.epam.library.dao.pool.exception.PropertyNotSetException;

public interface ConnectionPool<E> {

    public void initPool(PoolProperties poolProperties) throws InitPoolException, PropertyNotSetException;

    public E getConnection() throws PoolNotInitException, PoolConnectionException;

    public void realizeConnection(E connection) throws PoolConnectionException;

    public int getFreeConnections();

    public int size();

}
