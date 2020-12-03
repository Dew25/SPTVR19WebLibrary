<%-- 
    Document   : index
    Created on : Nov 24, 2020, 2:31:43 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Библиотека JPTVR19</title>
    </head>
    <body>
        <div>Наша библиотека</div>
        <p>${info}</p>
        <br>
        <a href="addBook">Добавить новую книгу</a><br>
        <a href="addReader">Добавить читателя</a><br>
        <a href="listBooks">Список книг</a><br>
        <a href="listReaders">Список читателей</a><br>
        <a href="takeOnBookForm">Выдать книгу читателю</a><br>
        
    </body>
</html>
