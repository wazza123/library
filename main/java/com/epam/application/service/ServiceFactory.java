package com.epam.application.service;


import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private Map<ServiceType,Service> services;
    private static ServiceFactory serviceFactory = new ServiceFactory();

    private ServiceFactory() {

        services = new HashMap<ServiceType, Service>();
        services.put(ServiceType.AUTHORIZATION, new AuthorizationService());
        services.put(ServiceType.REGISTRATION, new RegistrationService());
        services.put(ServiceType.BOOK_LIST, new BookListService());
        services.put(ServiceType.BOOK_INFO, new BookInfoService());
        services.put(ServiceType.FIND_BOOK, new FindBookService());
        services.put(ServiceType.DELETE_BOOK, new DeleteBookService());
        services.put(ServiceType.ADD_BOOK, new AddBookService());
        services.put(ServiceType.WRITER_INFO, new WriterInfoService());
        services.put(ServiceType.ADD_WRITER, new AddWriterService());
        services.put(ServiceType.FIND_WRITER, new FindWriterService());
        services.put(ServiceType.ADD_BOOK_AUTHOR, new AddBookAuthorService());
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

    public enum ServiceType {AUTHORIZATION,BOOK_LIST,REGISTRATION,BOOK_INFO,FIND_BOOK,
        DELETE_BOOK, ADD_BOOK,WRITER_INFO,ADD_WRITER,FIND_WRITER,ADD_BOOK_AUTHOR};
}
