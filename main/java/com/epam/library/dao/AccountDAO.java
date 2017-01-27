package com.epam.library.dao;


import com.epam.library.bean.Account;
import com.epam.library.dao.exception.DaoException;


public interface AccountDAO extends Dao {

    public void addAccount(Account account) throws DaoException;

    public Account getAccount(String log) throws DaoException;
}
