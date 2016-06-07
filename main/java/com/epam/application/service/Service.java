package com.epam.application.service;


import com.epam.application.service.exception.ServiceException;

public interface Service {

    public Object getInformation(Object... params) throws ServiceException;
}
