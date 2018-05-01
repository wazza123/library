package com.company.library.dao;


import com.company.library.bean.Account;
import com.company.library.dao.exception.DaoException;


public interface AccountDAO extends Dao {

    public void addAccount(Account account) throws DaoException;

    public Account getAccount(String log) throws DaoException;
}
