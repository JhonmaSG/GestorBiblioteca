<%-- 
    Document   : Ayuda
    Created on : 1/11/2023, 7:49:46 p. m.
    Author     : Jhon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Empleado" %>
<% HttpSession sesion = request.getSession();
 Empleado emp = (Empleado) sesion.getAttribute("usuario"); 
   if( emp != null ){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>AYUDA</title>
    </head>
    <body>

        <form class="needs-validation mx-auto text-center" onsubmit="" novalidate style="width:800px">

            <div class="jumbotron jumbotron-fluid mx-auto">
                <div class="container">
                    <img src="img/soporte.png" class="img-fluid" alt="" style=" width: 500px; height: 300px" />
                    <h1 class="display-4">Ayuda</h1>
                    <p class="lead">Aqui podras reportar algun inconveniente o problema de nuestros servicios</p>
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Nombres</label>
                    <input type="text" class="form-control" id="validationCustom01" placeholder="Ingrese los nombres" required>
                    <div class="valid-feedback">
                        Perfecto!
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom02">Apellidos</label>
                    <input type="text" class="form-control" id="validationCustom02" placeholder="Ingrese los apellidos" required>
                    <div class="valid-feedback">
                        Perfecto!
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationCustom03">Locación</label>
                    <select class="custom-select" id="validationCustom03" required>
                        <option selected disabled value="">Elija...</option>
                        <option value="1">Kennedy</option>
                        <option value="2">Soacha</option>
                        <option value="3">Ciudad Bolivar</option>
                        <option value="4">Chapinero</option>
                        <option value="5">Suba</option>
                        <option value="6">Usme</option>
                    </select>
                    <div class="invalid-feedback">
                        Seleccione una locación valida.
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="validationCustom04">Problema</label>
                    <select class="custom-select" id="validationCustom04" required>
                        <option selected disabled value="">Elija...</option>
                        <option value="1">Errores en datos de clientes</option>
                        <option value="2">Errores en datos de producto-serial</option>
                        <option value="3">Novedad Empleado</option>
                        <option value="4">Novedad Clientes</option>
                        <option value="5">Sugerencias</option>
                        <option value="6">Otro...</option>
                    </select>
                    <div class="invalid-feedback">
                        Seleccione un problema valido.
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="validationCustom05">Zip</label>
                    <input type="file" class="form-control" id="validationCustom05" required>
                    <div class="invalid-feedback">
                        Adjunte el archivo de la evidencia.
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                    <label class="form-check-label" for="invalidCheck">
                        Acepte los terminos y condiciones
                    </label>
                    <div class="invalid-feedback">
                        You must agree before submitting.
                    </div>
                </div>
            </div>
            <button class="btn btn-primary" value="" name="accion" type="submit">Enviar Reporte</button>
        </form>

        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict';
                window.addEventListener('load', function () {
                    // Fetch all the forms we want to apply custom Bootstrap validation styles to
                    var forms = document.getElementsByClassName('needs-validation');
                    // Loop over them and prevent submission
                    var validation = Array.prototype.filter.call(forms, function (form) {
                        form.addEventListener('submit', function (event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                                
                            }else{
                                mostrarAlerta();
                            }
                            form.classList.add('was-validated');
                            
                        }, false);
                        
                    });
                }, false);
                
            })();
        </script>

        <script>
            function mostrarAlerta() {
                alert("¡Reporte enviado, Gracias!");
            }
        </script>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

    </body>
</html>

<% } else{
    request.getRequestDispatcher("index.jsp").forward(request,response);
}
%>