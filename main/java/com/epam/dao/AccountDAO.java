package com.epam.dao;

import com.epam.dao.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends Dao {

    public void createAccount(String login, String password) throws DaoException {

        String query = "INSERT TABLE accounts VALUES('" + login + "','" + password + "');";

        try {

            executeUpdate(query);
        }
        catch (SQLException e) {

            throw new DaoException();
        }
        catch (ClassNotFoundException e) {

            throw new DaoException();
        }
        finally {


        }
    }

    public String getLogin(String login) {

        String query = "SELECT login FROM accounts WHERE login = '" + login + "';";

        ResultSet resultSet = null;
        try {
            resultSet = executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            while (resultSet.next()) {

                login = resultSet.getString(10);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            try {

                resultSet.close();
            } catch (SQLException e) {}
        }

        return login;
    }
    public String getPassword(String login) {

        return null;
    }
}
