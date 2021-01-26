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
        <title>Список читателей</title>
    </head>
    <body>
        <h1>Читатели:</h1>
        <select name="readerId" multiple="true">
            <option value="">Список читателей</option>
            <c:forEach var="reader" items="${listReaders}">
                <option value="${reader.id}">"${reader.name}". ${reader.lastname}. ${reader.phone} </option>
            </c:forEach>
        </select>
    </body>
</html>
