<%-- 
    Document   : listBooks
    Created on : 03.12.2020, 13:07:53
    Author     : jvm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <h1>Книги библиотеки:</h1>
        <select name="bookId" multiple="true">
            <option value="">Список книг</option>
            <c:forEach var="book" items="${listBooks}">
                <option value="${book.id}">"${book.name}". ${book.author}. ${book.publishedYear} </option>
            </c:forEach>
        </select>
    </body>
</html>
