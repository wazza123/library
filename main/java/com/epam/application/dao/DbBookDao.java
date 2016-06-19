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

        String query = "SELECT book_id,book_name,genre,annotation,book_file_path,cover_img_file_path " +
                "FROM books where book_id = ?;";
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
                    book.setId(resultSet.getInt("book_id"));
                    book.setName(resultSet.getString("book_name"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                    book.setBookFilePath(resultSet.getString("book_file_path"));
                    book.setBookCoverPath(resultSet.getString("cover_img_file_path"));
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

        String query = "SELECT book_id,book_name,genre,annotation,book_file_path,cover_img_file_path " +
                "FROM booklibrary.books " +
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
                    book.setId(resultSet.getInt("book_id"));
                    book.setName(resultSet.getString("book_name"));
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

        String query ="SELECT book_id,book_name,genre,annotation,book_file_path,cover_img_file_path\n" +
                "FROM books " +
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
                    book.setId(resultSet.getInt("book_id"));
                    book.setName(resultSet.getString("book_name"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                    book.setBookFilePath(resultSet.getString("book_file_path"));
                    book.setBookCoverPath(resultSet.getString("cover_img_file_path"));
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

    public List<Book> getBooksByAuthor(Writer author) throws DaoException {

        String query ="SELECT book_id,book_name,genre,annotation,book_file_path FROM books WHERE book_id IN \n" +
                "  (SELECT books_and_authors.book_id FROM books_and_authors WHERE writer_id = \n" +
                "  (SELECT writer_id FROM writers WHERE first_name = ? AND last_name = ?));";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        Writer writer = null;
        List<Book> books = new ArrayList<Book>();

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,author.getFirstName());
            preparedStatement.setString(2,author.getLastName());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("book_name") != null) {

                    book = new Book();
                    writer = new Writer();
                    book.setId(resultSet.getInt("book_id"));
                    book.setName(resultSet.getString("book_name"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                    book.setBookFilePath(resultSet.getString("book_file_path"));
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

    public List<Book> getAllBooks() throws DaoException {

        String query ="SELECT book_id,book_name,genre,annotation,book_file_path,cover_img_file_path " +
                "FROM booklibrary.books;";
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
                    book.setId(resultSet.getInt("book_id"));
                    book.setName(resultSet.getString("book_name"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setAnnotation(resultSet.getString("annotation"));
                    book.setBookFilePath(resultSet.getString("book_file_path"));
                    book.setBookCoverPath(resultSet.getString("cover_img_file_path"));
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

            e.printStackTrace();
            throw new DaoException(e);
        }
        catch (IOException e) {

            e.printStackTrace();
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

    public void addBook(Book book) throws DaoException {

        String query ="INSERT INTO books (book_name,genre,annotation,book_file_path)" +
                "  VALUES(?,?,?,?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2, book.getGenre());
            preparedStatement.setString(3,book.getAnnotation());
            preparedStatement.setString(4,book.getBookFilePath());
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {

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
    }

    public void deleteBook(int bookId) throws DaoException {

        String query ="DELETE FROM bookstemp WHERE book_id = " + bookId + ";";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,bookId);
            preparedStatement.executeUpdate(query);

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

    }

    public void addAuthor(int writerId, int bookId) throws DaoException {

        String query ="INSERT INTO books_and_authors (book_id,writer_id) \n" +
                "  VALUES (?,?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DbPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,bookId);
            preparedStatement.setInt(2, writerId);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {

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
    }
}
