package com.epam.application.service;


import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private Map<ServiceType,Service> services;
    private static ServiceFactory serviceFactory = new ServiceFactory();

    private ServiceFactory() {

        services = new HashMap<ServiceType, Service>();
        services.put(ServiceType.BOOK_LIST, new BookListService());
        services.put(ServiceType.BOOK_INFO, new BookInfoService());
        services.put(ServiceType.FIND_BOOK, new FindBookService());
    }

    public static ServiceFactory getFactory() {

        return serviceFactory;
    }

    public Service getService(ServiceType service) {

        return services.get(service);
    }

    public Service getService(String service) {

        return services.get(ServiceType.valueOf(service.toUpperCase()));
    }

    public enum ServiceType {BOOK_LIST,BOOK_INFO,FIND_BOOK};
}
