<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2><a href="index.jsp">main page</a>  </h2>
<c:forEach var="book" varStatus="status" items="${books}">
  <form action="controller" method="post">
    <img src="adad" height="65" width="40"/>
    <input type="hidden" name="command" value="delete_book">
    <input type="hidden" name="book_id" value="${book.id}">
    ${book.name}  <i>  by: ${book.author}</i>
    <input class="book" type="submit" value="delete">
  </form>
</c:forEach>
</body>
</html>
