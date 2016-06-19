package com.epam.application.dao;


import com.epam.application.bean.Writer;
import com.epam.application.dao.exception.DaoException;

import java.util.List;

public interface WriterDao extends Dao {

    public void addWriter(Writer writer) throws DaoException;

    public Writer getWriterById(int id) throws DaoException;

    public List<Writer> getWritersByBook(int bookId) throws DaoException;

    public List<Writer> getWritersByName(String firstName, String lastName) throws DaoException;
}
