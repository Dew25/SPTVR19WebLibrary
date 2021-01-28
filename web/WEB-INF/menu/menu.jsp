<%-- 
    Document   : menu
    Created on : Jan 28, 2021, 1:00:18 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Наша библиотека</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="listBooks">Список книг</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="takeOnBookForm">Взять книгу</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="returnBookForm">Вернуть книгу</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addBook">Добавить книгу</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="listReaders">Список читателей</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="adminPanel">Панель администратора</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="showLoginForm">Войти</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logout">Выйти</a>
        </li>
      </ul>
    </div>
  </div>
</nav>