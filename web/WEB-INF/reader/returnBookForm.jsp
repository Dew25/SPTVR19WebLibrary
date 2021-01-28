<%-- 
    Document   : listBooks
    Created on : 03.12.2020, 13:07:53
    Author     : jvm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Возврат книги в библиотеку</h3>
        <p>${info}</p>
        <form action="returnBook" method="POST">
            <select name="historyId" multiple="true">
                <option value="">Выберите возвращаемую книгу</option>
                <c:forEach var="history" items="${listHistoriesWithReadBook}">
                    <option value="${history.id}">"${history.book.name}" читает ${history.reader.name} ${history.reader.lastname} </option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Вернуть книгу">
        </form>

