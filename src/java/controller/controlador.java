/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import config.GenerarSerie;
import static config.Hash.encriptar;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static java.lang.Integer.parseInt;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import model.UsuarioDAO;
import model.Empleado;
import model.EmpleadoDAO;
import model.Libro;
import model.LibroDAO;
import model.Movimiento;
import model.MovimientoDAO;
import model.Usuario;
import model.Prestamo;
import model.PrestamoDAO;

/**
 *
 * @author Jhon
 */
public class controlador extends HttpServlet {

    //INSTANCIAR LAS CLASES
    Empleado usuario;
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;

    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    int idc;

    Movimiento mo = new Movimiento();
    MovimientoDAO mdao = new MovimientoDAO();
    int mdc;

    Libro li = new Libro();
    LibroDAO ldao = new LibroDAO();
    int idp;

    Prestamo p = new Prestamo();
    List<Prestamo> lista = new ArrayList<>();
    PrestamoDAO pdao = new PrestamoDAO();

    int item, cod, cantidad;
    String descripcion;
    double precio, subtotal;

    double totalP;

    //Almacena los datos y asocia un usuario a través de un identificador (ID de sesión)
    HttpSession sesion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");//Accion recibe la accion del user

        //Principal
        if (menu == null && menu != null) {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        if (menu.equals("Home")) {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        if (menu.equals("Principal")) {
            HttpSession sesion = request.getSession();
            us = (Usuario) sesion.getAttribute("usuario");
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Principal_Admin")) {
            HttpSession sesion = request.getSession();
            em = (Empleado) sesion.getAttribute("empleado");
            request.getRequestDispatcher("Principal_Admin.jsp").forward(request, response);
            //request.getRequestDispatcher("Home.jsp").forward(request, response);
        }

        //Empleado Biblioteca
        if (menu.equals("Empleado")) {
            //request.setAttribute("usuario", usuario);
            switch (accion) {
                case "Listar":
                    List lista = udao.listar();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Usuario c = udao.listarId(idc);
                    request.setAttribute("usuario", c);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Buscar por ID":
                    String consultaId = request.getParameter("txtconsulta");
                    if (consultaId.isEmpty()) { // Si la barra de búsqueda está vacía
                        request.setAttribute("usuarios", udao.listar()); // Mostrar todos los libros
                    } else {
                        int idLibro = Integer.parseInt(consultaId);
                        Usuario us = udao.listarId(idLibro);
                        List<Usuario> listaId = new ArrayList<>();
                        listaId.add(us);
                        request.setAttribute("usuarios", listaId); // Mostrar el resultado de la búsqueda
                    }
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Buscar por Cedula":
                    String consultaCedula = request.getParameter("txtconsulta");
                    if (consultaCedula.isEmpty()) { // Si la barra de búsqueda está vacía
                        request.setAttribute("usuarios", udao.listar()); // Mostrar todos los empleados
                    } else {
                        List<Usuario> usuarios = (List<Usuario>) udao.listarCedula(consultaCedula);
                        request.setAttribute("usuarios", usuarios); // Mostrar el resultado de la búsqueda
                    }
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    int id1 = parseInt(request.getParameter("txtId"));
                    String nom1 = request.getParameter("txtNom");
                    String ape1 = request.getParameter("txtApe");
                    String cedula1 = request.getParameter("txtCedula");
                    String correo1 = request.getParameter("txtCorreo");
                    String nombreUser1 = request.getParameter("txtUser");
                    String estado1 = request.getParameter("txtEstado");
                    String rol1 = request.getParameter("txtRol");

                    us.setId_usuario(id1);
                    us.setNombre(nom1);
                    us.setApellido(ape1);
                    us.setCedula(cedula1);
                    us.setCorreo(correo1);
                    us.setNombre_user(nombreUser1);
                    us.setEstado(estado1);
                    us.setRol(rol1);

                    us.setId_usuario(idc);
                    udao.actualizar(us);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    udao.delete(idc);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Generar Informe":
                    mdao.generarInforme(response, mdao.listar());
                    break;
                default:
                    System.out.println("Error Default switch Cliente");
                    throw new AssertionError();
            }
        }
        //Usuario
        if (menu.equals("Usuario")) {
            switch (accion) {
                case "AgregarCuenta":
                    String nom = request.getParameter("txtnombre");
                    String ape = request.getParameter("txtapellido");
                    String pass = request.getParameter("txtpass");
                    String peli = request.getParameter("txtpeli");
                    String dni = request.getParameter("txtdni");
                    String correo = request.getParameter("txtcorreo");
                    String nombreUser = request.getParameter("txtnombreuser");
                    us.setNombre(nom);
                    us.setApellido(ape);
                    us.setContraseña(pass);
                    us.setRespuesta(peli);
                    us.setCedula(dni);
                    us.setCorreo(correo);
                    us.setNombre_user(nombreUser);
                    udao.insertarUsuario(us);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    //request.getRequestDispatcher("controlador?menu=Usuario&accion=Agregar").forward(request, response);
                    break;
                case "CambiarContraseña":
                    String user1 = request.getParameter("txtuser");
                    String corr1 = request.getParameter("txtcorreo");
                    String dnii1 = request.getParameter("txtdni");
                    String resp1 = request.getParameter("txtrespuesta");
                    String contraNueva1 = request.getParameter("txtcontraNueva");
                    us.setNombre_user(user1);
                    us.setCorreo(corr1);
                    us.setCedula(dnii1);
                    us.setRespuesta(resp1);
                    //System.out.println("controller userDB: " + user1);
                    //System.out.println("controller corrDB: " + corr1);
                    //System.out.println("controller dniiDB: " + dnii1);
                    //System.out.println("controller respDB: " + resp1);
                    boolean decision = udao.recuperarContraseña(us, contraNueva1);
                    System.out.println("decision: " + decision);
                    if (decision == false) {
                        request.getRequestDispatcher("ContraCambiadaError.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("ContraCambiada.jsp").forward(request, response);
                    }
                    break;
                default:
                    System.out.println("Error Default switch Cliente");
                    throw new AssertionError();
            }
            //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Prestamo")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("prestamos", lista);
                    request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Prestamo pres = pdao.listarId(idp);
                    request.setAttribute("prestamo", pres);
                    request.getRequestDispatcher("controlador?menu=Prestamo&accion=Listar")
                            .forward(request, response);
                    break;
                case "Buscar por ID Prestamo":
                    String consultaId = request.getParameter("txtconsulta");
                    if (consultaId.isEmpty()) { // Si la barra de búsqueda está vacía
                        request.setAttribute("prestamos", pdao.listar()); // Mostrar todos los libros
                    } else {
                        int idPrestamo = Integer.parseInt(consultaId);
                        Prestamo pr = pdao.buscar(idPrestamo);
                        List<Prestamo> listaId = new ArrayList<>();
                        listaId.add(pr);
                        request.setAttribute("prestamos", listaId); // Mostrar el resultado de la búsqueda
                    }
                    request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
                    break;
                case "Buscar por ID Cliente":
                    String consultaIdUser = request.getParameter("txtconsulta");
                    if (consultaIdUser.isEmpty()) { // Si la barra de búsqueda está vacía
                        request.setAttribute("prestamos", pdao.listar()); // Mostrar todos los empleados
                    } else {
                        int idPrestamo = Integer.parseInt(consultaIdUser);
                        Prestamo pre = pdao.listarIdUser(idPrestamo);
                        List<Prestamo> listaId = new ArrayList<>();
                        listaId.add(pre);
                        request.setAttribute("prestamos", listaId);// Mostrar el resultado de la búsqueda
                    }
                    request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    int idLibro = parseInt(request.getParameter("txtidlibro"));
                    int idUsuario = parseInt(request.getParameter("txtidusuario"));
                    String fechaInicio = request.getParameter("txtfechainicio");
                    String fechalimite = request.getParameter("txtfechalimite");
                    String fechaEntrega = request.getParameter("txtfechaentrega");
                    int retrasoDias = parseInt(request.getParameter("txtretrasodias"));
                    int idEmpleadoPresta = parseInt(request.getParameter("txtidmepleadopresta"));
                    int idEmpleadoRecibe = parseInt(request.getParameter("txtidempleadorecibe"));

                    p.setId_libro(idLibro);
                    p.setId_usuario(idUsuario);
                    p.setFecha_inicio(fechaInicio);
                    p.setFecha_limite(fechalimite);
                    p.setFecha_entrega(fechaEntrega);
                    p.setRetraso_dias(retrasoDias);
                    p.setId_empleado_presta(idEmpleadoPresta);
                    p.setId_empleado_recibe(idEmpleadoRecibe);

                    p.setId_prestamo(idp);
                    pdao.actualizar(p);
                    request.getRequestDispatcher("controlador?menu=Prestamo&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    pdao.delete(idp);
                    request.getRequestDispatcher("controlador?menu=Prestamo&accion=Listar")
                            .forward(request, response);
                    request.getRequestDispatcher("Prestamo.jsp")
                            .forward(request, response);
                    break;
                case "Agregar":
                    int idLibro1 = parseInt(request.getParameter("txtidlibro"));
                    int idUsuario1 = parseInt(request.getParameter("txtidusuario"));
                    String fechaInicio1 = request.getParameter("txtfechainicio");
                    String fechalimite1 = request.getParameter("txtfechalimite");
                    String fechaEntrega1 = request.getParameter("txtfechaentrega");
                    int retrasoDias1 = parseInt(request.getParameter("txtretrasodias"));
                    int idEmpleadoPresta1 = parseInt(request.getParameter("txtidmepleadopresta"));
                    int idEmpleadoRecibe1 = parseInt(request.getParameter("txtidempleadorecibe"));

                    p.setId_libro(idLibro1);
                    p.setId_usuario(idUsuario1);
                    p.setFecha_inicio(fechaInicio1);
                    p.setFecha_limite(fechalimite1);
                    p.setFecha_entrega(fechaEntrega1);
                    p.setRetraso_dias(retrasoDias1);
                    p.setId_empleado_presta(idEmpleadoPresta1);
                    p.setId_empleado_recibe(idEmpleadoRecibe1);

                    pdao.agregarPrestamo(p);
                    pdao.actualizarStock(idLibro1); // Actualizar el stock después de agregar el préstamo

                    request.getRequestDispatcher("controlador?menu=Prestamo&accion=Listar").forward(request, response);
                    break;

                case "Generar Informe":
                    pdao.generarInforme(response, pdao.listar());
                    break;
                default:
                    System.out.println("Error Default switch Prestamo");
                    throw new AssertionError();
            }
            //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        ///Libros
        if (menu.equals("Inventario")) {
            switch (accion) {
                case "Listar":
                    List lista = ldao.listar();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("Inventario.jsp").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Libro c = ldao.listarId(idp);
                    request.setAttribute("libro", c);
                    request.getRequestDispatcher("controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Buscar por ID":
                    String consultaId = request.getParameter("txtconsulta");
                    if (consultaId.isEmpty()) { // Si la barra de búsqueda está vacía
                        request.setAttribute("libros", ldao.listar()); // Mostrar todos los libros
                    } else {
                        int idLibro = Integer.parseInt(consultaId);
                        Libro ca = ldao.buscar(idLibro);
                        List<Libro> listaId = new ArrayList<>();
                        listaId.add(ca);
                        request.setAttribute("libros", listaId); // Mostrar el resultado de la búsqueda
                    }
                    request.getRequestDispatcher("Inventario.jsp").forward(request, response);
                    break;
                case "Buscar por Titulo":
                    String consultaTitulo = request.getParameter("txtconsulta");
                    if (consultaTitulo.isEmpty()) { // Si la barra de búsqueda está vacía
                        request.setAttribute("libros", ldao.listar()); // Mostrar todos los libros
                    } else {
                        List<Libro> libros = (List<Libro>) ldao.listarTitulo(consultaTitulo);
                        request.setAttribute("libros", libros); // Mostrar el resultado de la búsqueda
                    }
                    request.getRequestDispatcher("Inventario.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    String titulo = request.getParameter("txttitulo");
                    String autor = request.getParameter("txtautor");
                    String genero = request.getParameter("txtgenero");
                    String publicacion = request.getParameter("txtpublicacion");
                    int cantidad = Integer.parseInt(request.getParameter("txtcantidad"));

                    li.setTitulo(titulo);
                    li.setAutor(autor);
                    li.setGenero(genero);
                    li.setPublicacion(publicacion);
                    li.setCantidad_disponible(cantidad);
                    li.setId_libro(idp);
                    ldao.actualizar(li);
                    request.getRequestDispatcher("controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    ldao.delete(idp);
                    request.getRequestDispatcher("controlador?menu=Inventario&accion=Listar").forward(request, response);
                    request.getRequestDispatcher("Inventario.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String titulo1 = request.getParameter("txttitulo");
                    String autor1 = request.getParameter("txtautor");
                    String genero1 = request.getParameter("txtgenero");
                    String publicacion1 = request.getParameter("txtpublicacion");
                    int cantidad1 = Integer.parseInt(request.getParameter("txtcantidad"));

                    li.setTitulo(titulo1);
                    li.setAutor(autor1);
                    li.setGenero(genero1);
                    li.setPublicacion(publicacion1);
                    li.setCantidad_disponible(cantidad1);
                    ldao.agregar(li);
                    request.getRequestDispatcher("controlador?menu=Inventario&accion=Listar").forward(request, response);
                    request.getRequestDispatcher("Inventario.jsp").forward(request, response);
                    break;
                case "Generar Informe":
                    ldao.generarInforme(response, ldao.listar());
                    break;
                default:
                    System.out.println("Error Default switch Cliente");
                    throw new AssertionError();
            }
            //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        //Nuevo Prestamo
        if (menu.equals("Ayuda")) {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Ayuda.jsp").forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
