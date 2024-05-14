<%-- 
    Document   : Home
    Created on : 25/3/2024, 4:16:19 p. m.
    Author     : Jhon
--%>

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
        <title>JSP Page</title>
    </head>
    <body>

        <div class="jumbotron" style="text-align: center;">
            <h1 class="display-4">Bienvenido ${usuario.getNom()}</h1>
            <p class="lead" style="color: black;">En este espacio virtual, te invitamos a sumergirte en el fascinante mundo del <br>
                conocimiento, la exploración y el descubrimiento a través de nuestra amplia colección de libros, revistas, <br>
                artículos y recursos digitales. Nuestro objetivo es brindarte una experiencia única y <br>
                enriquecedora, donde puedas satisfacer tus necesidades de información, investigación y entretenimiento.</p>
            <br>
            <hr class="my-4">
            
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/libro1.jpg" class="d-block w-65  mx-auto" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>ALEJANDRIA</h5>
                            <p>Gestor de biblioteca</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/libro2.jpg" class="d-block w-50 mx-auto" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Conoce nuestros libros mas populares</h5>
                            <p>colecciones mas populares entre los usuarios, segun sus categorias</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/libro3.jpg" class="d-block w-65  mx-auto" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>¡Miles de libros que buscan ser descubiertos por ti!</h5>
                            <p>Tenemos Miles de libros llenos de historia, aventura y educativos <br>que podras descubrir aqui</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/libro4.jpg" class="d-block w-65 mx-auto" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>¡Préstamos disponibles!</h5>
                            <p>Ya puedes realizar tus préstamos con elfin de llevarte los libros a casa</p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-target="#carouselExampleCaptions" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previo</span>
                </button>
                <button class="carousel-control-next" type="button" data-target="#carouselExampleCaptions" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Siguiente</span>
                </button>
            </div>
            <br><br>
            <div style="font-size: 20px;">
                <img src="img/logoBiblioteca.png" alt="70" width="300"/>
            </div>
        </div>

        <div class="card-deck text-center mx-auto"
             style="width: 1000px;">

            <div class="card" style="width: 16rem;">
                <img src="img/insignia.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Horarios</h5>
                    <p class="card-text">Nuestros Horarios se clasifican en ...</p>
                    <a href="#" class="btn btn-primary">Logros</a>
                </div>
            </div>

            <div class="card" style="width: 16rem;">
                <img src="img/comunicar.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Contactanos</h5>
                    <p class="card-text">Aqui podras conocer mas formas de contactarnos y las diferentes ent...</p>
                    <a href="#" class="btn btn-primary">Contactanos</a>
                </div>
            </div>

        </div>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>

<%
%>