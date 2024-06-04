<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Prestamo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>PRESTAMO</title>
    </head>
    <body>

        <h1 class="display-4">PRESTAMO</h1><br>

        <div class="d-flex">
            <div class="card w-50">
                <div class="card-body">
                    <form action="controlador?menu=Prestamo" method="POST">
                        <div class="form-group">
                            <label>Consultar Libro</label>
                            <input type="number" value="" name="txtconsulta" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Listar" class="btn btn-warning">
                        <input type="submit" name="accion" value="Buscar por ID Prestamo" class="btn btn-info">
                        <input type="submit" name="accion" value="Buscar por ID Cliente" class="btn btn-info">
                    </form>
                </div>
            </div>
            &nbsp; &nbsp; &nbsp;
            <div class="card w-25">
                <div class="card-body">
                    <form action="controlador?menu=Prestamo" method="POST">
                        <div class="form-group text-center">
                            <label>Generar informe de Prestamos</label><br><br>
                            <input type="submit" name="accion" value="Generar Informe" class="btn btn-warning">
                        </div>
                    </form>
                </div>
            </div>
        </div><br>

        <div class="d-flex">
            <div class="card">
                <div class="card-body">
                    <h3>Datos de Prestamo</h3><br>
                    <form action="controlador?menu=Prestamo" method="POST">
                        <div class="form-group">
                            <label>Id Prestamo</label>
                            <input type="number" value="${prestamo != null ? prestamo.getId_prestamo() : ''}" 
                                   name="txtidprestamo" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Id libro</label>
                            <input type="number" value="${prestamo != null ? prestamo.getId_libro() : ''}" 
                                   name="txtidlibro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Id Usuario</label>
                            <input type="number" value="${prestamo != null ? prestamo.getId_usuario() : ''}" 
                                   name="txtidusuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha inicio</label>
                            <input type="text" value="${prestamo != null ? prestamo.getFecha_inicio() : ''}" 
                                   name="txtfechainicio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha limite</label>
                            <input type="text" value="${prestamo != null ? prestamo.getFecha_limite() : '0000-00-00'}" 
                                   name="txtfechalimite" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha entrega</label>
                            <input type="text" value="${prestamo != null ? prestamo.getFecha_entrega() : null}" 
                                   name="txtfechaentrega" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Retraso Dias</label>
                            <input type="number" value="${prestamo != null ? prestamo.getRetraso_dias() : 0}" 
                                   name="txtretrasodias" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Id empleado presta</label>
                            <input type="number" value="${prestamo != null ? prestamo.getId_empleado_presta() : ''}" 
                                   name="txtidmepleadopresta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Id empleado recibe</label>
                            <input type="number" value="${prestamo != null ? prestamo.getId_empleado_recibe() : ''}" 
                                   name="txtidempleadorecibe" class="form-control">
                        </div>

                        <input type="submit" name="accion" value="Agregar" class="btn btn-success">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-info">
                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID PRESTAMO</th>
                            <th>ID LIBRO</th>
                            <th>ID USUARIO</th>
                            <th>FECHA INICIO</th>
                            <th>FECHA LIMITE</th>
                            <th>FECHA ENTREGA</th>
                            <th>RETRASO DIAS</th>
                            <th>ID EMPLEADO PRESTA</th>
                            <th>ID EMPLEADO RECIBE</th>
                            <th>ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pr" items="${prestamos}">
                            <tr>
                                <td>${pr.getId_prestamo()}</td>
                                <td>${pr.getId_libro()}</td>
                                <td>${pr.getId_usuario()}</td>
                                <td>${pr.getFecha_inicio()}</td>
                                <td>${pr.getFecha_limite()}</td>
                                <td>${pr.getFecha_entrega()}</td>
                                <td>${pr.getRetraso_dias()}</td>
                                <td>${pr.getId_empleado_presta()}</td>
                                <td>${pr.getId_empleado_recibe()}</td>
                                <td>
                                    <a class="btn btn-warning" href="controlador?menu=Prestamo&accion=Editar&id=${pr.getId_prestamo()}">Editar</a>
                                    <a class="btn btn-danger" href="controlador?menu=Prestamo&accion=Delete&id=${pr.getId_prestamo()}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" 
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" 
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" 
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
