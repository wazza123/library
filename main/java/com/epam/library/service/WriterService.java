package com.epam.library.service;


import com.epam.library.bean.Writer;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public interface WriterService extends Service {

    public boolean addWriter(Writer writer) throws ServiceException;

    public boolean findWriter(Writer writer) throws ServiceException;

    public Writer getWriter(int writerId) throws ServiceException;

    public List<Writer> getWriters(Writer writer) throws ServiceException;
}
