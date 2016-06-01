package com.epam.application.dao;


import com.epam.application.bean.Book;
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
import java.util.ArrayList;
import java.util.List;

public class DbBookDao implements BookDAO {

    private static final Logger LOGGER = Logger.getRootLogger();

    public Book getBookById(int id) throws DaoException {

        String query = "SELECT books.book_id,book_name,genre,publisher,annotation,book_file_path,first_name,last_name " +
                "FROM booklibrary.books INNER JOIN booklibrary.writers " +
                "INNER JOIN booklibrary.books_and_authors " +
                "ON writers.writer_id = books_and_authors.writer_id AND books.book_id = books_and_authors.book_id " +
                "where books.book_id = ?;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        Writer writer = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("book_name") != null) {

                    book = new Book();
                    writer = new Writer();
                    book.setId(resultSet.getInt("books.book_id"));
                    book.setName(resultSet.getString("book_name"));
                    writer.setFirstName(resultSet.getString("first_name"));
                    writer.setLastName(resultSet.getString("last_name"));
                    book.setAuthor(writer);
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
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

        return book;
    }

    public List<Book> getBooksByName(String name) throws DaoException {

        String query = "SELECT books.book_id,book_name,genre,publisher,annotation,book_file_path,first_name,last_name " +
                "FROM booklibrary.books INNER JOIN booklibrary.writers " +
                "INNER JOIN booklibrary.books_and_authors " +
                "ON writers.writer_id = books_and_authors.writer_id AND books.book_id = books_and_authors.book_id " +
                "where book_name LIKE ?;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        Writer writer = null;
        List<Book> books = new ArrayList<Book>();

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"%" + name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("book_name") != null) {

                    book = new Book();
                    writer = new Writer();
                    book.setId(resultSet.getInt("books.book_id"));
                    book.setName(resultSet.getString("book_name"));
                    writer.setFirstName(resultSet.getString("first_name"));
                    writer.setLastName(resultSet.getString("last_name"));
                    book.setAuthor(writer);
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                }

                books.add(book);
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

        return books;
    }

    public List<Book> getBooksByGenre(String genre) throws DaoException {

        String query ="SELECT books.book_id,book_name,genre,publisher,annotation,book_file_path,first_name,last_name\n" +
                "FROM booklibrary.books INNER JOIN booklibrary.writers \n" +
                "INNER JOIN booklibrary.books_and_authors \n" +
                "ON writers.writer_id = books_and_authors.writer_id AND books.book_id = books_and_authors.book_id\n" +
                "where genre = ?;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        Writer writer = null;
        List<Book> books = new ArrayList<Book>();

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,genre);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("book_name") != null) {

                    book = new Book();
                    writer = new Writer();
                    book.setId(resultSet.getInt("books.book_id"));
                    book.setName(resultSet.getString("book_name"));
                    writer.setFirstName(resultSet.getString("first_name"));
                    writer.setLastName(resultSet.getString("last_name"));
                    book.setAuthor(writer);
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                }

                books.add(book);
            }

        } catch (SQLException e) {

            LOGGER.error(e);
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

        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        return null;
    }

    public List<Book> getAllBooks() throws DaoException {

        String query ="SELECT books.book_id,book_name,genre,publisher,annotation,book_file_path,first_name,last_name " +
                "FROM booklibrary.books INNER JOIN booklibrary.writers " +
                "INNER JOIN booklibrary.books_and_authors " +
                "ON writers.writer_id = books_and_authors.writer_id AND books.book_id = books_and_authors.book_id;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        Writer writer = null;
        List<Book> books = new ArrayList<Book>();

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("book_name") != null) {

                    book = new Book();
                    writer = new Writer();
                    book.setId(resultSet.getInt("books.book_id"));
                    book.setName(resultSet.getString("book_name"));
                    writer.setFirstName(resultSet.getString("first_name"));
                    writer.setLastName(resultSet.getString("last_name"));
                    book.setAuthor(writer);
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                }

                books.add(book);
            }

        } catch (SQLException e) {

            LOGGER.error(e);
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

        return books;
    }
}
