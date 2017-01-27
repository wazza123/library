package com.epam.library.service;


import com.epam.library.bean.Account;
import com.epam.library.service.exception.ServiceException;

public interface AccountService extends Service {

    public Account getAccount(String login) throws ServiceException;

    public boolean authorize(Account account) throws ServiceException;

    public boolean registrate(Account account) throws ServiceException;
}
