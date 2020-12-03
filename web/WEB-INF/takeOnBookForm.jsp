<%-- 
    Document   : takeBookForm
    Created on : 03.12.2020, 13:37:38
    Author     : jvm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выдать книгу</title>
    </head>
    <body>
        <h1>Выдать книгу</h1>
        <form action="takeOnBook" method="POST">
            <select name="bookId">
                <option value="">Выберите книгу</option>
                <c:forEach var="book" items="${listBooks}">
                    <option value="${book.id}">"${book.name}". ${book.author}. ${book.publishedYear} </option>
                </c:forEach>
            </select>
            <br>
            <select name="readerId">
                <option value="">Список читателей</option>
                <c:forEach var="reader" items="${listReaders}">
                    <option value="${reader.id}">"${reader.name}". ${reader.lastname}. ${reader.phone} </option>
                </c:forEach>
            </select>    
            <br>
            <input type="submit" value="Выдать книгу">
        </form>    
    </body>
</html>
