package com.epam.application.command;


import com.epam.application.command.exception.CommandException;
import com.epam.application.service.Service;
import com.epam.application.service.ServiceFactory;
import com.epam.application.service.exception.ServiceException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;


public class AddBookCommand implements Command {

    private final String PAGE = "WEB-INF/adminMainPage.jsp";
    private final String BOOK_NAME_ATTRIBUTE = "book_name";
    private final String AUTHOR_ATTRIBUTE = "author";
    private final String GENRE_ATTRIBUTE = "genre";
    private final String ANNOTATION_ATTRIBUTE = "annotation";
    private final String BOOK_FILE_ATTRIBUTE = "book_file";

    private void writeFile(HttpServletRequest request) {

        boolean isMultipart;
        String filePath;
        int maxFileSize = 50 * 1024;
        int maxMemSize = 4 * 1024;
        File file;
        //filePath = request.getServletContext().getInitParameter("file-upload");
        filePath = "D:\\erp\\";
        isMultipart = ServletFileUpload.isMultipartContent(request);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );

        try{
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            while ( i.hasNext () )
            {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () )
                {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file
                    if( fileName.lastIndexOf("\\") >= 0 ){

                        file = new File( filePath + "sss") ;
                    }else{
                        file = new File( filePath + "sss") ;
                    }
                    fi.write(file) ;
                }
            }
        }catch(Exception ex) {
            System.out.println(ex);

    }
}

    public String execute(HttpServletRequest request) throws CommandException {

        String bookName = request.getParameter(BOOK_NAME_ATTRIBUTE);
        String author = request.getParameter(AUTHOR_ATTRIBUTE);
        String genre = request.getParameter(GENRE_ATTRIBUTE);
        String annotation = request.getParameter(ANNOTATION_ATTRIBUTE);
        String bookFile = request.getParameter(BOOK_FILE_ATTRIBUTE);

        ServiceFactory serviceFactory = ServiceFactory.getFactory();
        Service service = serviceFactory.getService(ServiceFactory.ServiceType.ADD_BOOK);

        try {

            //writeFile(request);
            service.getInformation(bookName,author,genre,annotation);
        }
        catch (ServiceException e) {

            throw new CommandException(e);
        }

        return PAGE;
    }
}
