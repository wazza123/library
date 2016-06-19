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
  <c:forEach var="auth" varStatus="status" items="${author}">
  ${auth}
    </c:forEach>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="find_writer">
    <input type="hidden" name="book_id" value="<jsp:getProperty name="book_info" property="id"/>">
    first name <input type="text" name="first_name">
    last name <input type="text" name="last_name">
    <input type="submit" value="find writer">
  </form>
</div>
<div class="book_information">
  <jsp:getProperty name="book_info" property="annotation"/>
</div>

<input type="hidden" name="command" value="delete_book">
<input type="hidden" name="book_id" value="<jsp:getProperty name="book_info" property="id"/>">
<input class="book" type="submit" value="delete">
</div>
</body>
</html>