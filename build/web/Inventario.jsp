<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Empleado" %>
<% HttpSession sesion = request.getSession();
 Empleado emp = (Empleado) sesion.getAttribute("usuario"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>INVENTARIO</title>
    </head>
    <body>
        
        <h1 class="display-4">INVENTARIO</h1>
        
        <div class="d-flex">
            <div class="card">
                <div class="card-body">
                    <form action="controlador?menu=Inventario" method="POST">
                        <div class="form-group">
                            <label>Id</label>
                            <input type="text" value="${libro.getId_libro()}" name="txtid" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" value="${libro.getTitulo()}" name="txttitulo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Autor</label>
                            <input type="text" value="${libro.getAutor()}" name="txtautor" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Genero</label>
                            <input type="text" value="${libro.getGenero()}" name="txtgenero" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Publicacion</label>
                            <input type="text" value="${libro.getPublicacion()}" name="txtpublicacion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Cantidad</label>
                            <input type="text" value="${libro.getCantidad_disponible()}" name="txtcantidad" class="form-control">
                        </div>

                        <!--<input type="submit" name="accion" value="Agregar" class="btn btn-info">-->
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>TITULO</th>
                            <th>AUTOR</th>
                            <th>GENERO</th>
                            <th>PUBLICACION</th>
                            <th>CANTIDAD</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="li" items="${libros}">
                            <tr>
                                <td>${li.getId_libro()}</td>
                                <td>${li.getTitulo()}</td>
                                <td>${li.getAutor()}</td>
                                <td>${li.getGenero()}</td>
                                <td>${li.getPublicacion()}</td>
                                <td>${li.getCantidad_disponible()}</td>
                                <td>
                                    <a class="btn btn-warning" href="controlador?menu=Inventario&accion=Editar&id=${li.getId_libro()}">Editar</a>
                                    <a class="btn btn-danger" href="controlador?menu=Inventario&accion=Delete&id=${li.getId_libro()}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>

<%
%>
