package com.epam.application.dao;


import com.epam.application.dao.connectionPool.ConnectionPool;
import com.epam.application.dao.connectionPool.DbPool;
import com.epam.application.dao.connectionPool.exception.InitPoolException;
import com.epam.application.dao.connectionPool.exception.PoolConnectionException;
import com.epam.application.dao.connectionPool.exception.PoolNotInitException;
import com.epam.application.dao.connectionPool.exception.PropertyNotSetException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionCreator {

    private static ConnectionPool pool;

    protected Connection getConnection() throws PoolNotInitException, PoolConnectionException {


        try {
            pool = DbPool.createPool();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyNotSetException e) {
            e.printStackTrace();
        } catch (InitPoolException e) {
            e.printStackTrace();
        }

        return (Connection) pool.getConnection();
    }

    protected void closeConnection(Connection connection) throws PoolConnectionException {

        pool.retrieveConnection(connection);
    }

    protected void closeStatement(Statement statement) throws SQLException {

        statement.close();
    }
}
