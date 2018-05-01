package com.company.library.dao.pool.impl;

import com.company.library.dao.pool.ConnectionPool;
import com.company.library.dao.pool.PoolProperties;
import com.company.library.dao.pool.exception.InitPoolException;
import com.company.library.dao.pool.exception.PoolConnectionException;
import com.company.library.dao.pool.exception.PropertyNotSetException;
import com.company.library.dao.pool.exception.PoolNotInitException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class DbConnectionPool implements ConnectionPool {

    private BlockingQueue<Connection> connections;
    private PoolProperties properties;
    private int size;

    public DbConnectionPool() {}

    public void initPool(PoolProperties poolProperties) throws InitPoolException, PropertyNotSetException {

        properties = poolProperties;
        size = properties.getPoolSize();
        connections = new ArrayBlockingQueue<Connection>(size);

        try {

            for (int i = 0; i < size; i++) {

                Class.forName(properties.getDriver());
                connections.put(DriverManager.getConnection(properties.getUrl(), properties.getLogin(), properties.getPassword()));
            }
        }
        catch (ClassNotFoundException e) {

            throw new InitPoolException("problems during initialization occurs", e);
        }
        catch (SQLException e) {

            throw new InitPoolException("problems during initialization occurs", e);
        }
        catch (InterruptedException e) {

            throw new InitPoolException("problems during initialization occurs", e);
        }
    }

    public Connection getConnection() throws PoolNotInitException, PoolConnectionException {

        if (connections == null) {

            throw new PoolNotInitException("pool has not been initialized");
        }

        try {

            return connections.take();
        }
        catch (InterruptedException e) {

            throw new PoolConnectionException("problem with getting connection occur",e);
        }
    }

    public void realizeConnection(Object connection) throws PoolConnectionException {

        try {

            connections.put((Connection) connection);
        }
        catch (InterruptedException e) {

            throw new PoolConnectionException("problem with retrieving connection occur",e);
        }
    }

    public int getFreeConnections() {

        return connections.size();
    }

    public int size() {

        return size;
    }
}
