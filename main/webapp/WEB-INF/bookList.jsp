<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="styles/mainPageStyle.css">
    <style><%@include file="styles/bookListStyle.css"%></style>
</head>
<body>
<h2><a href="index.jsp">main page</a>  </h2>
<div>
    Category: ${book_type}
</div>
<%--@elvariable id="books" type="java.util.List"--%>
<c:forEach var="book" varStatus="status" items="${books}">
    <form action="controller" method="post">
        <img src="${book.bookCoverPath}" height="65" width="40"/>
        <input type="hidden" name="command" value="book_info">
        <input class="book" type="submit" name="book_name" value="${book.name}">
        <i>by: ${book.author}</i>
        <input class="book" type="hidden" name="book_id" value="${book.id}">
    </form>
</c:forEach>
<c:if test="${empty books}">
    nothing to show
</c:if>
</body>
</html>
