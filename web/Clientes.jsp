<%-- 
    Document   : Cliente
    Created on : 7/10/2023, 5:47:30 p. m.
    Author     : Jhon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>CLIENTES</title>
    </head>
    <body>

        <h1 class="display-4">Clientes</h1>

        <div class="d-flex">
            <div class="card w-50">
                <div class="card-body">
                    <form action="controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Consultar Usuario</label>
                            <input type="text" value="" name="txtconsulta" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Listar" class="btn btn-warning">
                        <input type="submit" name="accion" value="Buscar por ID" class="btn btn-info">
                        <input type="submit" name="accion" value="Buscar por Cedula" class="btn btn-info">
                    </form>
                </div>
            </div>

            &nbsp; &nbsp;
            <div class="card w-25">
                <div class="card-body">
                    <form action="controlador?menu=Empleado" method="POST">
                        <div class="form-group text-center">
                            <label>Generar informe<br>Historial de usuarios</label><br><br>
                            <input type="submit" name="accion" value="Generar Informe" class="btn btn-warning">
                        </div>
                    </form>
                </div>
            </div>
        </div><br>



    <div class="d-flex">
        <div class="card">
            <div class="card-body">
                <form action="controlador?menu=Empleado" method="POST">
                    <div class="form-group">
                        <label>Id</label>
                        <input type="number" value="${usuario.getId_usuario()}" name="txtId" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Nombres</label>
                        <input type="text" value="${usuario.getNombre()}" name="txtNom" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Apellidos</label>
                        <input type="text" value="${usuario.getApellido()}" name="txtApe" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Cedula</label>
                        <input type="number" value="${usuario.getCedula()}" name="txtCedula" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Correo</label>
                        <input type="text" value="${usuario.getCorreo()}" name="txtCorreo" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>User</label>
                        <input type="text" value="${usuario.getNombre_user()}" name="txtUser" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" value="${usuario.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Rol</label>
                        <input type="text" value="${usuario.getRol()}" name="txtRol" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-info">
                </form>
            </div>
        </div>

        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>PASSWORD</th>
                        <th>RESPUESTA_SEG</th>
                        <th>CEDULA</th>
                        <th>CORREO</th>
                        <th>USER</th>
                        <th>ESTADO</th>
                        <th>ROL</th>
                        <th>ACCION</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usu" items="${usuarios}">
                        <tr>
                            <td>${usu.getId_usuario()}</td>
                            <td>${usu.getNombre()}</td>
                            <td>${usu.getApellido()}</td>
                            <td>${usu.getContraseña()}</td>
                            <td>${usu.getRespuesta()}</td>
                            <td>${usu.getCedula()}</td>
                            <td>${usu.getCorreo()}</td>
                            <td>${usu.getNombre_user()}</td>
                            <td>${usu.getEstado()}</td>
                            <td>${usu.getRol()}</td>



                            <td>
                                <a class="btn btn-warning" href="controlador?menu=Empleado&accion=Editar&id=${usu.getId_usuario()}">Editar</a>
                                <a class="btn btn-danger" href="controlador?menu=Empleado&accion=Delete&id=${usu.getId_usuario()}">Delete</a>
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


