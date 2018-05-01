package com.company.library.service;


import com.company.library.bean.Writer;
import com.company.library.service.exception.ServiceException;

import java.util.List;

public interface WriterService extends Service {

    public boolean addWriter(Writer writer) throws ServiceException;

    public boolean findWriter(Writer writer) throws ServiceException;

    public Writer getWriter(int writerId) throws ServiceException;

    public List<Writer> getWriters(Writer writer) throws ServiceException;
}
