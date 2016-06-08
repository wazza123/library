package com.epam.application.service;


import com.epam.application.service.exception.ServiceException;

public interface Service {

    public Object execute(Object... params) throws ServiceException;
}
