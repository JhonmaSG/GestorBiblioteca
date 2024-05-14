<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>CREAR CUENTA</title>
    </head>
    <body style="background: #989898;">
        <div class="container mt-4 col-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="controlador?menu=Usuario&accion=AgregarCuenta" method="POST">
                        <div class="form-group text-center">
                            <h3>CREAR CUENTA</h3>
                            <img src="img/userCrearCuenta.png" alt="70" width="170"/>
                            
                            <label style="display: block"><br><b>Alexandria</b></label>
                            <label style="display: block">Ingresa tus datos personales para tener una cuenta personal</label>
                        </div>
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" name="txtnombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Apellido:</label>
                            <input type="text" name="txtapellido" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>¿Cual es tu pelicula favorita?:</label>
                            <input type="password" name="txtpeli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dni:</label>
                            <input type="text" name="txtdni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo:</label>
                            <input type="email" name="txtcorreo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre de Usuario:</label>
                            <input type="text" name="txtnombreuser" class="form-control">
                        </div>                   
                     
                        <input type="submit" name="accion" value="¡Voy a tener cuenta!" class="btn btn-primary">
                        <input type="submit" name="accion" value="Atras" class="btn btn-danger">
                        <input type="reset" name="accion" value="Limpiar" class="btn btn-warning">
                    </form>
                </div>
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