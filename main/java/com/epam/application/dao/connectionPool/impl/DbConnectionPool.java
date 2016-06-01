package com.epam.application.dao.connectionPool.impl;

import com.epam.application.dao.connectionPool.ConnectionPool;
import com.epam.application.dao.connectionPool.PoolProperties;
import com.epam.application.dao.connectionPool.exception.InitPoolException;
import com.epam.application.dao.connectionPool.exception.PoolConnectionException;
import com.epam.application.dao.connectionPool.exception.PoolNotInitException;
import com.epam.application.dao.connectionPool.exception.PropertyNotSetException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class DbConnectionPool implements ConnectionPool {

    private static final Logger LOGGER = Logger.getRootLogger();
    private BlockingQueue<Connection> connections;
    private PoolProperties properties;
    private int size;

    public DbConnectionPool() {}

    public synchronized void initPool(PoolProperties poolProperties) throws InitPoolException, PropertyNotSetException {

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

    public synchronized Connection getConnection() throws PoolNotInitException, PoolConnectionException {

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

    public synchronized void retrieveConnection(Object connection) throws PoolConnectionException {

        try {

            connections.put((Connection) connection);
        }
        catch (InterruptedException e) {

            throw new PoolConnectionException("problem with retrieving connection occur",e);
        }
    }

    public synchronized void cleanPool() {

        while (!connections.isEmpty()) {

            Connection connection = connections.poll();

            try {

                connection.close();
            }
            catch (SQLException e) {

                LOGGER.error("some connections are not closed");
            }
            finally {

                size = connections.size();
            }
        }
    }

    public synchronized int freeConnections() {

        return size - ( size - connections.size() );
    }

    public int size() {

        return size;
    }
}
