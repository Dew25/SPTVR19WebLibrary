<%-- 
    Document   : addBookForm
    Created on : Nov 24, 2020, 1:59:55 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3 class="w-100 text-center  my-5">Добавить книгу</h3>
        <div class="" style="width: 50rem; margin: 0 auto">
            <a class="btn btn-primary my-2" href="uploadForm">Загрузить обложку книги</a>
            <form action="createBook" method="POST">
                  <div class="mb-3 row">
                    <label for="name" class="col-sm-3 col-form-label">Название книги:</label>
                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="name" name="name" value="${name}">
                    </div>
                  </div>
                  <div class="mb-3 row">
                    <label for="login" class="col-sm-3 col-form-label">Автор книги:</label>
                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="author" name="author" value="${author}">
                    </div>
                  </div>
                  <div class="mb-3 row">
                    <label for="publishedYear" class="col-sm-3 col-form-label">Год издания книги: </label>
                    <div class="col-sm-9">
                      <input type="text" class="form-control" name="publishedYear" id="publishedYear" value="${publishedYear}">
                    </div>
                  </div>
                  <div class="mb-3 row">
                    <label for="login" class="col-sm-3 col-form-label">Обложка: </label>
                    <div class="col-sm-9">
                        <select class="form-select" name="coverId">
                            <option value="">Выберите обложку</option>
                            <c:forEach var="cover" items="${listCovers}">
                                <option value="${cover.id}">${cover.description}</option>
                            </c:forEach>
                        </select>
                    </div>
                  </div>
                <div class="col-sm-12">
                  <button type="submit" class="btn btn-primary mb-3 w-100">Отправить</button>
                </div>
            </form>
        </div>