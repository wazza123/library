package com.epam.library.dao;


import com.epam.library.bean.Writer;
import com.epam.library.dao.exception.DaoException;

import java.util.List;

public interface WriterDao extends Dao {

    public void addWriter(Writer writer) throws DaoException;

    public Writer getWriterById(int id) throws DaoException;

    public List<Writer> getWritersByBook(int bookId) throws DaoException;

    public List<Writer> getWritersByName(String firstName, String lastName) throws DaoException;
}
