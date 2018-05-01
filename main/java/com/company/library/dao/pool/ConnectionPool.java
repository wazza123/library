package com.company.library.dao.pool;


import com.company.library.dao.pool.exception.InitPoolException;
import com.company.library.dao.pool.exception.PoolConnectionException;
import com.company.library.dao.pool.exception.PropertyNotSetException;
import com.company.library.dao.pool.exception.PoolNotInitException;

public interface ConnectionPool<E> {

    public void initPool(PoolProperties poolProperties) throws InitPoolException, PropertyNotSetException;

    public E getConnection() throws PoolNotInitException, PoolConnectionException;

    public void realizeConnection(E connection) throws PoolConnectionException;

    public int getFreeConnections();

    public int size();

}
