package com.epam.dao;


import org.apache.tomcat.jdbc.pool.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    protected Dao() {

    }

    protected Statement createStatement() throws ClassNotFoundException, SQLException, NamingException {

        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");
        Connection connection = ds.getConnection();
        ResultSet resultSet = createStatement().getResultSet();
    }

    protected void close(Statement statement) throws SQLException {


    }

    protected ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {


        return null;
    }

    protected void executeUpdate(String query) throws SQLException, ClassNotFoundException {


    }
}
