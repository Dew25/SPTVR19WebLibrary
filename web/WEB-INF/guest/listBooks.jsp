<%-- 
    Document   : listBooks
    Created on : Dec 1, 2020, 1:03:10 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>Книги библиотеки:</h3>
<form action="editBookForm" method="POST">
    <select name="bookId" multiple="true">
        <option value="">Список книг</option>
        <c:forEach var="book" items="${listBooks}">
            <option value="${book.id}">"${book.name}". ${book.author}. ${book.publishedYear}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Изменить выбранную книгу">
</form>
    
