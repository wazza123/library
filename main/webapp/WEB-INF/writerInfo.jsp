<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="styles/bookInfoStyle.css">
  <style><%@include file="styles/bookInfoStyle.css"%></style>

</head>
<body>

<h2><a href="index.jsp">main page</a>  </h2>
<img class="book_picture" src="dsff"/>
<div class="book_title">
  ${author}
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<div>
  <h1>other writer's books:</h1>
  <c:forEach var="book" varStatus="status" items="${books}">
    <form action="controller" method="post">
      <img src="${book.bookCoverPath}" height="65" width="40"/>
      <input type="hidden" name="command" value="book_info">
      <input class="book" type="submit" name="book_name" value="${book.name}">
      <i>by: ${book.author}</i>
      <input class="book" type="hidden" name="book_id" value="${book.id}">
    </form>
  </c:forEach>
</div>
</body>
</html>

