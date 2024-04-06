<%-- 
    Document   : index
    Created on : 25/3/2024, 4:16:19 p. m.
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
        <link rel="stylesheet" href="style.css">
        <title>PRINCIPAL</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">

            <div class="collapse navbar-collapse" id="navbarNav" style="padding-left: 50px;">
                <ul class="navbar-nav">
                    <li class="nav-item active" id="gestor">
                        <img src="img/logoBiblioteca.png" alt="10" width="110"/>
                        <b>
                            <div id="gestorName"></div>
                        </b>

                    </li>
                    <div class="collapse navbar-collapse" id="menuNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active" id="labelHome">
                                <a class="nav-link"
                                   href="controlador?menu=Home" target="myFrame">Home</a>
                            </li>
                            <div class="collapse navbar-collapse" id="menuItemsCenter">
                                <li class="nav-item">
                                    <a class="btn btn-outline-light" 
                                       href="controlador?menu=Empleado&accion=Listar" target="myFrame">Administracion</a>
                                </li>
                                <li class="nav-item">
                                    <a class="btn btn-outline-light" 
                                       href="controlador?menu=Producto&accion=Listar" target="myFrame">Inventario</a>
                                </li>
                                <li class="nav-item">
                                    <a class="btn btn-outline-light" 
                                       href="controlador?menu=Cliente&accion=Listar" target="myFrame">Prestamo</a>
                                </li>
                        </ul>
                    </div>
                </ul>
            </div>
        </div>
    </div>

    <div class="dropdown">
        <button style="border: none; font-size: 20px;" class="btn btn-outline-light dropdown-toggle" type="button" 
                data-toggle="dropdown" aria-expanded="false">
            ${usuario.getNom()}
        </button>
        <div class="dropdown-menu text-center">
            <a class="dropdown-item" href="#">
                <img src="img/user.png" alt="60" width="60"/>
            </a>
            <a class="dropdown-item" href="#">${usuario.getUser()}</a>
            <a class="dropdown-item" href="#">${usuario.getUser()}@gmail.com</a>
            <a class="dropdown-item" href="#" id="cambiar-contraseña">Cambiar contraseña</a>
            <a class="dropdown-item" href="#" id="mostrar-horario">Horarios</a>
            <div class="dropdown-divider"></div>

            <form action="validar" method="POST">
                <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
            </form>

        </div>
    </div>

    <script>
        document.getElementById('cambiar-contraseña').addEventListener('click', function () {
            alert('¡La contraseña se cambiará pronto!');
        });
        document.getElementById('mostrar-horario').addEventListener('click', function () {
            alert('¡Pronto visualizaras los horarios!');
        });
    </script>

</nav>

<div class="m-4" style="height: 689px; margin-bottom: 0px;">
    <iframe name="myFrame" style="height: 100%; width: 100%; max-height: 1080px; border: none;"></iframe>
</div>

<blockquote class="blockquote text-center mx-auto bg-primary" style="background: #333333; margin-bottom: 0px;">
    <p class="mb-0" style="color: white;">© Todos los Derechos Reservados 2024 </p>
    <footer class="blockquote-footer" style="color: black;">Alexandria: Gestor de biblioteca.</footer>
</blockquote>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>

<% } else{
    request.getRequestDispatcher("index.jsp").forward(request,response);
}
%>