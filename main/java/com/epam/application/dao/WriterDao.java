package com.epam.application.dao;


import com.epam.application.bean.Writer;
import com.epam.application.dao.exception.DaoException;

public interface WriterDao extends Dao {

    public Writer getWriterById(int id) throws DaoException;

    public Writer getWriterByBook(int bookId) throws DaoException;

    public Writer getWriterByName(String firstName, String lastName) throws DaoException;
}
