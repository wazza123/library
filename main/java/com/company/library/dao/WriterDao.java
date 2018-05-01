package com.company.library.dao;


import com.company.library.bean.Writer;
import com.company.library.dao.exception.DaoException;

import java.util.List;

public interface WriterDao extends Dao {

    public void addWriter(Writer writer) throws DaoException;

    public Writer getWriterById(int id) throws DaoException;

    public List<Writer> getWritersByBook(int bookId) throws DaoException;

    public List<Writer> getWritersByName(String firstName, String lastName) throws DaoException;
}
