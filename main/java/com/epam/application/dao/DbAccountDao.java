package com.epam.application.dao;


import com.epam.application.bean.Account;
import com.epam.application.dao.connectionPool.DbPool;
import com.epam.application.dao.connectionPool.exception.*;
import com.epam.application.dao.exception.DaoException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccountDao implements AccountDAO {

    private static Logger LOGGER = Logger.getRootLogger();

    public void addAccount(Account account) throws DaoException {

        String login = account.getLogin();
        String password = account.getPassword();
        String query = "INSERT INTO accounts(login, password) VALUES(?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {

                LOGGER.error(e.getMessage());
                throw new DaoException(e);
            }
            catch (DbPoolException e) {

                throw new DaoException(e);
            }
            finally {

                try {

                    if (preparedStatement != null) {

                        preparedStatement.close();
                    }

                    DbPool.returnConnection(connection);
                }
                catch (DbPoolException e) {

                    LOGGER.error("fail to return connection to pool",e);
                }
                catch (SQLException e) {

                    LOGGER.error("fail to close connection", e);
                }
        }

    }

    public Account getAccount(String log) throws DaoException {

        String query = "SELECT login,password,role FROM accounts WHERE login = ?;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String login = null;
        String password = null;
        String role = null;
        Account account = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,log);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                login = resultSet.getString("login");
                password = resultSet.getString("password");
                role = resultSet.getString("role");
            }

            if (login != null) {

                account = new Account();
                account.setLogin(login);
                account.setPassword(password);
                account.setRole(role);
            }

        } catch (SQLException e) {

            throw new DaoException(e);
        }
        catch (DbPoolException e) {

            throw new DaoException(e);
        }
        finally {

            try {

                if (preparedStatement != null) {

                    preparedStatement.close();
                }

                if (resultSet != null) {

                    resultSet.close();
                }

                if (connection != null) {

                    DbPool.returnConnection(connection);
                }
            }
            catch (SQLException e) {

                LOGGER.error("fail to close connection", e);
            }
            catch (DbPoolException e) {

                LOGGER.error("fail to return connection to pool",e);
            }
        }

        return account;
    }
}
