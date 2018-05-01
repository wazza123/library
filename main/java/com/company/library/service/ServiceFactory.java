package com.company.library.service;


import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private Map<ServiceType,Service> services;
    private static ServiceFactory serviceFactory = new ServiceFactory();

    private ServiceFactory() {

        services = new HashMap<ServiceType, Service>();
        services.put(ServiceType.DAO_ACCOUNT_SERVICE, new DaoAccountService());
        services.put(ServiceType.DAO_BOOK_SERVICE, new DaoBookService());
        services.put(ServiceType.DAO_WRITER_SERVICE, new DaoWriterService());
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

    public enum ServiceType {DAO_ACCOUNT_SERVICE, DAO_BOOK_SERVICE, DAO_WRITER_SERVICE};
}
