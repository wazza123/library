package com.epam.application.dao.connectionPool;


import com.epam.application.dao.connectionPool.exception.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

public final class DbPool {

    private static ConnectionPool pool;

    private DbPool() {}

    public static ConnectionPool createPool() throws DbPoolException {

        if (pool == null) {

            try {

                PoolProperties poolProperties = new PoolProperties();
                poolProperties.setProperties(new File("D:\\pool.properties"));
                PoolFactory poolFactory = PoolFactory.getPoolFactory();
                pool = poolFactory.getPool(PoolFactory.PoolType.DB_POOL);
                pool.initPool(poolProperties);
            }
            catch (PropertyNotSetException e) {

                throw new DbPoolException(e);
            }
            catch (InitPoolException e) {

                throw new DbPoolException(e);
            }
            catch (IOException e) {

                throw new DbPoolException(e);
            }
        }

        return pool;
    }

    public static Connection getConnection() throws DbPoolException {

        createPool();
        try {

            return (Connection) pool.getConnection();
        }
        catch (PoolNotInitException e) {

            throw new DbPoolException(e);
        }
        catch (PoolConnectionException e) {

            throw new DbPoolException(e);
        }
    }

    public static void returnConnection(Connection connection) throws DbPoolException {

        try {

            pool.retrieveConnection(connection); //if connection != null
        }
        catch (PoolConnectionException e) {

            throw new DbPoolException(e);
        }
    }
}
