<%-- 
    Document   : takeBookForm
    Created on : 03.12.2020, 13:37:38
    Author     : jvm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Выдать книгу</h3>
        <form action="takeOnBook" method="POST">
            <select name="bookId">
                <option value="">Выберите книгу</option>
                <c:forEach var="book" items="${listBooks}">
                    <option value="${book.id}">"${book.name}". ${book.author}. ${book.publishedYear} </option>
                </c:forEach>
            </select>
            <br>
            
            <br>
            <input type="submit" value="Взять книгу">
        </form>    
        <p>
            <c:forEach var="book" items="${listReadBooks}">
                <!--список взятых пользователем книг-->
                  <div class="card" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">${book.name}</h5>
                      <p class="card-text">${book.author}</p>
                      <p class="card-text">${book.publishedYear}</p>
                      <a href="#" class="btn btn-primary">Читать</a>
                    </div>
                  </div>
            </c:forEach>
        </p>

