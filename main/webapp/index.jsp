<%@ page import="java.util.List" %>
<%@ page import="com.epam.application.bean.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <head>
    <title></title>
    <style><%@include file="WEB-INF/styles/mainPageStyle.css"%></style>
  </head>


<div >
<form action="controller" method="post">
  <input type="hidden" name="command" value="find_book" />
  <input class="text-area" type="text" name="book_title">
  <input type="submit" value="find book"/>
</form>
</div>

<div class="genres">
  <form action="controller" method="post">
    <input type="hidden" name="command" value="book_list" />
    <input type="hidden" name="book_type" value="all" />
    <input type="submit" value="All books"/>
  </form>
<form action="controller" method="post">
  <input type="hidden" name="command" value="book_list" />
  <input type="hidden" name="book_type" value="Biography" />
  <input type="submit" value="Biography"/>
</form>
<form action="controller" method="post">
  <input type="hidden" name="command" value="book_list" />
  <input type="hidden" name="book_type" value="other" />
  <input type="submit" value="Other"/>
</form>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="book_list" />
    <input type="hidden" name="book_type" value="other" />
    <input type="submit" value="Other"/>
  </form>

  <form action="controller" method="post">
    <input type="hidden" name="command" value="book_list" />
    <input type="hidden" name="book_type" value="other" />
    <input type="submit" value="Other"/>
  </form>

</div>

  </body>
</html>
