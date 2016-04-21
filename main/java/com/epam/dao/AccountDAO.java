package com.epam.dao;

import com.epam.dao.exception.DaoException;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO extends Dao {

    public void createAccount(String login, String password) throws DaoException {

        String query = "INSERT TABLE accounts VALUES('" + login + "','" + password + "');";
        Connection connection = null;
        Statement statement = null;

        try {

            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException e) {

            throw new DaoException();
        }
        catch (ClassNotFoundException e) {

            throw new DaoException();
        }
        catch (NamingException e) {

            throw new DaoException();
        }

    }

    public String getLogin(String login) {

        String query = "SELECT login FROM accounts WHERE login = '" + login + "';";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                login = resultSet.getString("login");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        catch (NamingException e) {

            e.printStackTrace();
        }
        finally {

            try {

                connection.close();
            }
            catch (SQLException e) {}
        }

        return login;
    }
    public String getPassword(String login) {

        return null;
    }
}
