<%-- 
    Document   : addBookForm
    Created on : Nov 24, 2020, 1:59:55 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Добавить книгу</h3>
        <p>${info}</p>
        <a href="uploadForm">Загрузить обложку книги</a>
        <form action="createBook" method="POST">
            Название книги: <input type="text" name="name" value="${name}"><br>
            Автор книги: <input type="text" name="author" value="${author}"><br>
            Год издания книги: <input type="text" name="publishedYear" value="${publishedYear}"><br>
            Обложка: <input type="text" name="cover" value="${cover.description}">
            <input type="hidden" name="coverId" value="${cover.id}">
           <input type="submit" value="Отправить"><br>
        </form>
   