package com.epam.application.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    protected Dao() {}

    protected Connection getConnection() throws ClassNotFoundException, SQLException {

        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://mysql33673-webapp.mycloud.by/my_bd";
        final String LOGIN =  "user";
        final String PASSWORD = "umqfZzMMPR5AHjHp";

        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    protected void close(Connection connection) throws SQLException {

        connection.close();
    }

}
