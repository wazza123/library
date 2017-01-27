<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="styles/mainPageStyle.css">
</head>

<body>
<h2><a href="index.jsp">main page</a>  </h2>
<form action="controller" method="post">
  <input type="hidden" name="command" value="logout"/>
  <input type="submit" value="sign out">
</form>

<div >
  <form action="controller" method="post">
    <input type="hidden" name="command" value="find_book" />
    <input class="text-area" type="text" name="book_title">
    <input type="submit" value="find book"/>
  </form>
</div>
<div class="genres">
  <form action="addBook" method="post">
    <input type="submit" value="add book"/>
  </form>
  <form action="addWriter" method="post">
    <input type="submit" value="add writer"/>
  </form>
</div>

</div>
</body>
</html>
