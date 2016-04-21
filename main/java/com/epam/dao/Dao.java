package com.epam.dao;


import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

    protected Dao() {

    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {


        return null;
    }

    protected void close(Connection connection) throws SQLException {

        connection.close();
    }

    protected ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {


        return null;
    }

    protected void executeUpdate(String query) throws SQLException, ClassNotFoundException {


    }
}
