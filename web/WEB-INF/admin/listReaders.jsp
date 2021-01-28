<%-- 
    Document   : listBooks
    Created on : 03.12.2020, 13:07:53
    Author     : jvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Читатели:</h3>
        <select name="readerId" multiple="true">
            <option value="">Список читателей</option>
            <c:forEach var="reader" items="${listReaders}">
                <option value="${reader.id}">"${reader.name}". ${reader.lastname}. ${reader.phone} </option>
            </c:forEach>
        </select>
    
