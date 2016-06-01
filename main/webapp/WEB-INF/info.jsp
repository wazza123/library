<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="styles/bookInfoStyle.css">
    <style><%@include file="styles/bookInfoStyle.css"%></style>

</head>
<body>
<img class="book_picture" src="sdd"/>
<jsp:useBean id="book_info" class="com.epam.application.bean.Book" scope="request" >
</jsp:useBean>
<div class="book_title">
    <jsp:getProperty name="book_info" property="name"/>
</div>
<div class="book_author">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="writer_info">
  <input type="submit" value="<jsp:getProperty name="book_info" property="author"/> "/>
    </form>
</div>
<div class="book_information">
    <jsp:getProperty name="book_info" property="annotation"/>
</div>
<div>
    <a href="D:\\corejava7_2_book.pdf" download >download book</a>
</div>
</body>
</html>
