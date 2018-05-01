package com.company.library.service;


import com.company.library.bean.Account;
import com.company.library.service.exception.ServiceException;

public interface AccountService extends Service {

    public Account getAccount(String login) throws ServiceException;

    public boolean authorize(Account account) throws ServiceException;

    public boolean registrate(Account account) throws ServiceException;
}
