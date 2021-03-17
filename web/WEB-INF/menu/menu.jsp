<%-- 
    Document   : menu
    Created on : Jan 28, 2021, 1:00:18 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Наша библиотека</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav w-100 d-flex justify-content-end">
          <c:if test="${role eq 'ADMIN'}">
            <li class="nav-item">
                <a class="nav-link <c:if test="${activeListBooks eq true}">active</c:if>" aria-current="page" href="listBooks">Список книг</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeTakeOnBookForm eq true}">active</c:if>" href="takeOnBookForm">Взять книгу</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeAddBook eq true}">active</c:if>" href="addBook">Добавить книгу</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeListReaders eq true}">active</c:if>" href="listReaders">Список читателей</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeAdminPanel eq true}">active</c:if>" href="adminPanel">Панель администратора</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeLogout eq true}">active</c:if>" href="logout">Выйти</a>
            </li>
          </c:if>
          <c:if test="${role eq 'MANAGER'}">
            <li class="nav-item">
                <a class="nav-link <c:if test="${activeListBooks eq true}">active</c:if>" aria-current="page" href="listBooks">Список книг</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeTakeOnBookForm eq true}">active</c:if>" href="takeOnBookForm">Взять книгу</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeAddBook eq true}">active</c:if>" href="addBook">Добавить книгу</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeLogout eq true}">active</c:if>" href="logout">Выйти</a>
            </li>
          </c:if>
          <c:if test="${role eq 'READER'}">
            <li class="nav-item">
                <a class="nav-link <c:if test="${activeListBooks eq true}">active</c:if>" aria-current="page" href="listBooks">Список книг</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeTakeOnBookForm eq true}">active</c:if>" href="takeOnBookForm">Взять книгу</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeLogout eq true}">active</c:if>" href="logout">Выйти</a>
            </li>
          </c:if>
          <c:if test="${role eq null}">
            <li class="nav-item">
                <a class="nav-link <c:if test="${activeListBooks eq true}">active</c:if>" aria-current="page" href="listBooks">Список книг</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <c:if test="${activeShowLoginForm eq true}">active</c:if>" href="showLoginForm">Войти</a>
            </li>
          </c:if>
          
      </ul>
    </div>
  </div>
</nav>