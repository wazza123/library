package com.epam.application.dao.connectionPool;


import com.epam.application.dao.connectionPool.exception.InitPoolException;
import com.epam.application.dao.connectionPool.exception.PoolConnectionException;
import com.epam.application.dao.connectionPool.exception.PoolNotInitException;
import com.epam.application.dao.connectionPool.exception.PropertyNotSetException;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

public final class DbPool {

    private static ConnectionPool pool;

    private DbPool() {}

    public static ConnectionPool createPool() throws IOException, PropertyNotSetException, InitPoolException {

        if (pool == null) {

            PoolProperties poolProperties = new PoolProperties();
            poolProperties.setProperties(new File("C:\\Users\\home\\IdeaProjects\\library\\src\\main\\resources\\pool.properties"));
            PoolFactory poolFactory = PoolFactory.getPoolFactory();
            pool = poolFactory.getPool(PoolFactory.PoolType.DB_POOL);
            pool.initPool(poolProperties);
        }

        return pool;
    }

    public static Connection getConnection() throws PoolNotInitException, PoolConnectionException, InitPoolException, IOException, PropertyNotSetException {

        createPool();
        return (Connection) pool.getConnection();
    }

    public static void returnConnection(Connection connection) throws PoolConnectionException {

        pool.retrieveConnection(connection); //if connection != null
    }
}
