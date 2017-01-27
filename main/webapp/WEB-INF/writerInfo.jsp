<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="styles/bookInfoStyle.css">

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
  <c:forEach var="writer" varStatus="status" items="${books}">
    <form action="controller" method="post">
      <img src="${writer.bookCoverPath}" height="65" width="40"/>
      <input type="hidden" name="command" value="book_info">
      <input type="hidden" name="book_id" value="${writer.id}">
      <input type="submit" name="book_name" value="${writer.name}">
      <i>by: ${author}</i>
    </form>
  </c:forEach>
</div>
</body>
</html>

