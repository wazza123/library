<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="styles/bookInfoStyle.css">
    <style><%@include file="styles/bookInfoStyle.css"%></style>

</head>
<body>

<h2><a href="index.jsp">main page</a>  </h2>
<jsp:useBean id="book_info" class="com.epam.application.bean.Book" scope="request" ></jsp:useBean>
<img class="book_picture" src="<jsp:getProperty name="book_info" property="bookCoverPath"/>"/>
<div class="book_title">
    <jsp:getProperty name="book_info" property="name"/>
    <input type="hidden" name = "book_id" value="<jsp:getProperty name="book_info" property="id"/>">
</div>
<div class="book_author">
    <jsp:getProperty name="book_info" property="author"/>
</div>
<div class="book_information">
    <jsp:getProperty name="book_info" property="annotation"/>
</div>

<div class="downloadButton">
    <c:if test="${isAuthorized}">
        <a href="<jsp:getProperty name="book_info" property="bookFilePath"/>" download >download book</a>
    </c:if>
    <c:if test="${!isAuthorized}">
        sign in to download book
    </c:if>
</div>
</body>
</html>
