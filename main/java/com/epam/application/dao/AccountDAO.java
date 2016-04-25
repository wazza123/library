package com.epam.application.dao;

import com.epam.application.bean.Account;
import com.epam.application.dao.exception.DaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO extends Dao {

    public void addAccount(Account account) throws DaoException {

        String login = account.getLogin();
        String password = account.getPassword();
        String query = "INSERT TABLE accounts VALUES('" + login + "','" + password + "');";
        Connection connection = null;
        Statement statement = null;

        try {

            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException e) {

            throw new DaoException(e);
        }
        catch (ClassNotFoundException e) {

            throw new DaoException(e);
        }

    }

    public Account getAccount(String log) throws DaoException {

        String query = "SELECT login,password FROM accounts WHERE login = '" + log + "';";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String login = null;
        String password = null;
        Account account = null;

        try {

            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                login = resultSet.getString("login");
                password = resultSet.getString("password");
            }

            if (login != null) {

                account = new Account();
                account.setLogin(login);
                account.setPassword(password);
            }

        } catch (SQLException e) {

            throw new DaoException(e);
        }
        catch (ClassNotFoundException e) {

            throw new DaoException(e.getMessage(),e);
        }
        finally {

            try {

                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {}
        }

        return account;
    }
}
