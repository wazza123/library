<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <input type="hidden" name="book_type" value="Drama" />
        <input type="submit" value="Drama"/>
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="book_list" />
        <input type="hidden" name="book_type" value="other" />
        <input type="submit" value="Other"/>
    </form>

</div>

</body>
</html>