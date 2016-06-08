package com.epam.application.dao;


import com.epam.application.bean.Writer;
import com.epam.application.dao.connectionPool.DbPool;
import com.epam.application.dao.connectionPool.exception.InitPoolException;
import com.epam.application.dao.connectionPool.exception.PoolConnectionException;
import com.epam.application.dao.connectionPool.exception.PoolNotInitException;
import com.epam.application.dao.connectionPool.exception.PropertyNotSetException;
import com.epam.application.dao.exception.DaoException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbWriterDao implements WriterDao {

    private static final Logger LOGGER = Logger.getRootLogger();
    public Writer getWriterById(int id) {

        return null;
    }

    public Writer getWriterByBook(int bookId) throws DaoException {

        String query = "SELECT writer_id, first_name, last_name FROM writers WHERE writer_id = \n" +
                "  (SELECT writer_id FROM books_and_authors WHERE book_id = ?);";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Writer writer = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,bookId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("first_name") != null) {

                    writer = new Writer();
                    writer.setId(resultSet.getInt("writer_id"));
                    writer.setFirstName(resultSet.getString("first_name"));
                    writer.setFirstName(resultSet.getString("last_name"));


                }
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
            throw new DaoException(e);
        }
        catch (PoolNotInitException e) {

            throw new DaoException(e);
        }
        catch (PoolConnectionException e) {

            throw new DaoException(e);
        }
        catch (PropertyNotSetException e) {

            throw new DaoException(e);
        }
        catch (InitPoolException e) {

            throw new DaoException(e);
        }
        catch (IOException e) {

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
            catch (PoolConnectionException e) {

                LOGGER.error("fail to return connection to pool",e);
            }
        }

        return writer;
    }

    public Writer getWriterByName(String firstName, String lastName) {

        return null;
    }
}
