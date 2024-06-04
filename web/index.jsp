<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Alejandria Login</title>
    </head>
    <body style="background: #989898;">
        <div class="container mt-4 col-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="validar" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/logoBiblioteca.png" alt="70" width="170"/>

                            <label style="display: block"><br><h3><b>Bienvenido a Alexandria</b></h3></label>
                            <label style="display: block">Gestos de Biblioteca</label><br>

                            <label class="underline">
                                <a href="#" data-toggle="modal" data-target="#horariosModal"><b>Horarios de la biblioteca</b></a>
                            </label>
                            <hr>

                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="txtpass" class="form-control">
                            <input type="submit" name="accion" value="Olvide mi contraseña" class="btn btn-link">
                        </div>
                        <label>
                            <input type="checkbox" name="terminos" id="terminos" required>
                            Al continuar, estás de acuerdo con los <a href="#" data-toggle="modal" data-target="#terminosModal">Términos y Condiciones</a>
                            de la biblioteca.
                        </label><br><br>

                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary" id="btnIngresar" disabled>
                        <input type="submit" name="accion" value="Crear Cuenta" class="btn btn-info" id="btnCrearCuenta" disabled>
                        <input type="reset" name="accion" value="Limpiar" class="btn btn-warning">
                    </form>
                </div>
            </div>
        </div>

        <div class="modal fade" id="terminosModal" tabindex="-1" role="dialog" aria-labelledby="terminosModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-center" id="terminosModalLabel">Términos y Condiciones</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>1. Registro y Membresía</h5>
                        <p>
                            Para poder utilizar los servicios de préstamo de la biblioteca, es necesario registrarse como miembro. 
                            El registro es gratuito y puede realizarse en línea o en persona en nuestras instalaciones. 
                            Al registrarse, el usuario acepta proporcionar información veraz y actualizada. La membresía es personal e intransferible.
                        </p>

                        <h5>2. Préstamo de Libros</h5>
                        <p>
                            Los miembros pueden tomar prestados un libro a la vez. 
                            El período de préstamo estándar es de 30 días, con la posibilidad de renovar el préstamo por otros 8 días, 
                            siempre y cuando el libro no haya sido reservado por otro miembro. Las renovaciones pueden realizarse en la biblioteca.
                        </p>

                        <h5>3. Devoluciones</h5>
                        <p>
                            Los libros deben ser devueltos en la fecha de vencimiento o antes. 
                            La devolución puede realizarse en cualquiera de nuestras sucursales durante el horario de atención. 
                            Los libros devueltos deben estar en buen estado, sin daños ni marcas.
                        </p>

                        <h5>6. Uso de las Instalaciones</h5>
                        <p>
                            Los miembros tienen acceso a todas las instalaciones de la biblioteca, incluyendo salas de lectura, áreas de estudio y recursos electrónicos. 
                            Se espera que todos los usuarios mantengan un comportamiento respetuoso y no perturben a otros usuarios. El uso de dispositivos electrónicos 
                            está permitido, siempre y cuando no interfiera con la tranquilidad del ambiente.
                        </p>

                        <h5>7. Privacidad y Protección de Datos</h5>
                        <p>
                            La biblioteca se compromete a proteger la privacidad de sus miembros. 
                            La información personal recopilada durante el proceso de registro será utilizada únicamente para la gestión de la membresía y los servicios de préstamo. 
                            No compartiremos su información con terceros sin su consentimiento.
                        </p>

                        <h5>8. Modificación de los Términos y Condiciones</h5>
                        <p>
                            La biblioteca se reserva el derecho de modificar estos términos y condiciones en cualquier momento. 
                            Las modificaciones serán publicadas en el sitio web de la biblioteca y entrarán en vigor inmediatamente después de su publicación. S
                            e recomienda a los miembros revisar regularmente los términos y condiciones para estar informados de cualquier cambio.
                        </p>

                        <h5>9. Contacto</h5>
                        <p>
                            Si tiene alguna pregunta o inquietud sobre estos términos y condiciones, no dude en ponerse en contacto con nosotros 
                            a través del correo electrónico info@biblioteca.com o llamando al (123) 456-7890.
                            Estamos aquí para ayudarle.
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
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


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" 
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" 
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" 
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
        <script>
            document.getElementById('terminos').addEventListener('change', function () {
                var ingresarButton = document.getElementById('btnIngresar');
                var crearCuentaButton = document.getElementById('btnCrearCuenta');
                ingresarButton.disabled = !this.checked;
                crearCuentaButton.disabled = !this.checked;
            });
        </script>
    </body>
</html>
