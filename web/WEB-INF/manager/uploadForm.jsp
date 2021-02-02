<%-- 
    Document   : uploadForm
    Created on : Feb 2, 2021, 10:07:09 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Загрузить файл</h3>
        <form action="uploadCover" method="POST"  enctype="multipart/form-data">
            <div class="row mb-3">
              <label for="file" class="form-label">Выберите локальный файл</label>
              <input class="form-control" type="file" name="file" id="file">
            </div>
            <div class=" row mb-3">
              <label for="description" class="form-label">Описание</label>
              <input class="form-control" type="text" name="description" id="description">
            </div>
            <div class="row">
                <button type="submit" class="btn btn-primary">Загрузить файл</button>
            </div>
        </form>
    
