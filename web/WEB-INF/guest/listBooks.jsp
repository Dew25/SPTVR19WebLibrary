<%-- 
    Document   : listBooks
    Created on : Dec 1, 2020, 1:03:10 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="w-100 text-center  my-5">Книги библиотеки:</h3>
<div class="w-100 d-flex justify-content-center">
    <c:forEach var="book" items="${listBooks}">
      <div class="card m-2" style="min-width: 12rem;">
          <img src="insertFile/${book.cover.path}"  class="card-img-top" alt="..." style="max-width: 12rem; max-height: 15rem">
        <div class="card-body">
          <h5 class="card-title">${book.name}</h5>
          <p class="card-text">${book.author}</p>
          <p class="card-text">${book.publishedYear}</p>
          <p class="card-text">Цена: ${book.price}</p>
          <a href="#" class="btn btn-primary">Читать</a>
          <a href="#" class="btn btn-primary">Купить</a>
        </div>
      </div>
    </c:forEach>
</div>

    
