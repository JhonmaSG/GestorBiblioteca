<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Empleado" %>
<%@page import="model.Usuario" %>

<% HttpSession sesion = request.getSession();
 //Empleado emp = (Empleado) sesion.getAttribute("usuario");
 Empleado emp = (Empleado) sesion.getAttribute("empleado"); 
   if( emp != null){
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
                                       href="controlador?menu=Prestamo&accion=Listar" target="myFrame">Prestamo</a>
                                </li>
                                <li class="nav-item">
                                    <a class="btn btn-outline-light" 
                                       href="controlador?menu=Empleado&accion=Listar" target="myFrame">Administracion</a>
                                </li>
                                <li class="nav-item">
                                    <a class="btn btn-outline-light" 
                                       href="controlador?menu=Inventario&accion=Listar" target="myFrame">Inventario</a>
                                </li>

                        </ul>
                    </div>
                </ul>
            </div>
        </div>
    </div>

    <div class="dropdown">
        <button style="border: none; font-size: 20px; width: 200px;" class="btn btn-outline-light dropdown-toggle" type="button" 
                data-toggle="dropdown" aria-expanded="false">
            ${empleado.getNom()}
        </button>
        <div class="dropdown-menu text-center">
            <a class="dropdown-item" href="#">
                <img src="img/user.png" alt="60" width="60"/>
            </a>
            <a class="dropdown-item" href="#">${empleado.getNom()}</a>
            <a class="dropdown-item" href="#">${empleado.getUser()}@gmail.com</a>
            <a class="dropdown-item" href="#" id="cambiar-contraseña">Cambiar contraseña</a>
            <a class="dropdown-item" href="#"  data-toggle="modal" data-target="#horariosModal">Horarios</a>
            <div class="dropdown-divider"></div>

            <form action="validar" method="POST">
                <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
            </form>

        </div>
    </div>

    <div class="modal fade" id="horariosModal" tabindex="-1" role="dialog" aria-labelledby="horariosModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-center" id="horariosModalLabel">Horarios de la Biblioteca</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h5>Horarios de Atención</h5>
                    <p>
                        Lunes a Viernes: 8:00 AM - 5:00 PM<br>
                        Sábados: 9:00 AM - 2:00 PM<br>
                        Domingos y Festivos: Cerrado
                    </p>
                    <h5>Horarios Especiales</h5>
                    <p>
                        PROXIMAMENTE...
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.getElementById('cambiar-contraseña').addEventListener('click', function () {
            alert('¡Debera salir para cambiar la contraseña!');
        });
    </script>

</nav>

<div class="m-4" style="height: 736px; margin-bottom: 0px;">
    <iframe id="myFrame" name="myFrame" style="height: 100%; width: 100%; max-height: 1080px; border: none;"></iframe>
</div>

<blockquote class="blockquote text-center mx-auto bg-primary" style="background: #333333; margin-bottom: 0px;">
    <p class="mb-0" style="color: white;">© Todos los Derechos Reservados 2024 </p>
    <footer class="blockquote-footer" style="color: black;">Alexandria: Gestor de biblioteca.</footer>
</blockquote>

<script>
// Espera a que la página se cargue completamente
    window.addEventListener('load', function () {
// Accede al iframe
        var iframe = document.getElementById('myFrame');
// Cambia el src del iframe hacia home.jsp
        iframe.src = 'Home.jsp';
    });
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