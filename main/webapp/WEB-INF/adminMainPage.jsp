<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
  <title></title>
  <style><%@include file="styles/mainPageStyle.css"%></style>
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

<form action="controller" method="post" enctype="multipart/form-data">
  <input type="hidden" name="command" value="add_book">
  book name <input type="text" name="book_name">
  author  <input type="text" name="author">
  genre <input type="text" name="genre"><br>
  annotation <textarea name="annotation"></textarea><br>
  <input type="submit" value="add book">

</form>
</body>
</html>
