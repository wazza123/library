<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="controller" method="post">
  <input type="hidden" name="command" value="add_book">
  book name <input type="text" name="book_title">
  author  <input type="text" name="author">
  genre <input type="text" name="genre">
  annotation <textarea name="annotation"></textarea>
  <input type="file" name="book_file">
  <input type="submit" value="ok">
</form>
</body>
</html>
