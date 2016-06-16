<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="controller" method="post">
  <input type="hidden" name="command" value="add_book">
  book name <input id="book_name" type="text" name="book_name">
  author  <input id="author" type="text" name="author">
  genre <input id="genre" type="text" name="genre"><br>
  annotation <textarea id="annotation" name="annotation"></textarea><br>
  <input type="submit" value="add book">
</form>
<p id="msg" style="color: red"></p>
<div>
  <form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" size="5000000000" name="upload">
    <input type="submit" value="upload">
  </form>
</form>
  </div>
</body>
</html>
