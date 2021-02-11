<%-- 
    Document   : takeBookForm
    Created on : 03.12.2020, 13:37:38
    Author     : jvm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <h3 class="w-100 text-center  my-5">Взять книгу</h3>
    <div class="w-100 d-flex justify-content-center">
        <form action="takeOnBook" method="POST">
            <select class="form-control" name="bookId">
                <option value="">Выберите книгу</option>
                <c:forEach var="book" items="${listBooks}">
                    <option value="${book.id}">"${book.name}". ${book.author}. ${book.publishedYear} </option>
                </c:forEach>
            </select>
            <input class="m-2" type="submit" value="Взять книгу">
        </form>    
    </div>  
    <div class="w-100 my-4">
        <div class="row w-100 d-flex justify-content-center border">
            <h4>${user.reader.name} ${user.reader.lastname} читает следующие книги:</h4>
        </div>
        <div class="row w-100 d-flex justify-content-center">
            <c:forEach var="book" items="${listReadBooks}">
              <div class="card col m-2 text-center" style="min-width: 12rem;">
                <img src="insertFile/${book.cover.path}" class="mx-auto img-thumbnail" style="max-width: 7rem; max-height: 10rem" class="card-img-top" alt="${book.cover.description}">
                <div class="card-body">
                  <h5 class="card-title">${book.name}</h5>
                  <p class="card-text">${book.author}</p>
                  <p class="card-text">${book.publishedYear}</p>
                  <p class="card-text">Цена: ${book.price}</p>
                  <a href="readBook?bookId=${book.id}" class="btn btn-primary btn-sm">Читать</a>
                </div>
              </div>
            </c:forEach>
        </div>
    </div>

