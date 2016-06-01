<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style><%@include file="styles/bookListStyle.css"%></style>
</head>
<body>
<div>
    Category: ${book_type}
</div>
<c:forEach var="book" varStatus="status" items="${books}">
    <form action="controller" method="post">
        <img src="adad" height="65" width="40"/>
        <input type="hidden" name="command" value="book_info">
        <input class="book" type="submit" name="book_name" value="${book.name}">
        <i>by: ${book.author}</i>
        <input class="book" type="hidden" name="book_id" value="${book.id}">
    </form>
</c:forEach>
</body>
</html>
