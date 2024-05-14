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

import model.UsuarioDAO;
import model.Empleado;
import model.EmpleadoDAO;
import model.Libro;
import model.LibroDAO;
import model.Usuario;
import model.Venta;
import model.VentaDAO;

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

    Libro li = new Libro();
    LibroDAO ldao = new LibroDAO();
    int idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item, cod, cantidad;
    String descripcion;
    double precio, subtotal;

    double totalP;

    VentaDAO vdao = new VentaDAO();
    String numeroSerie;

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
                case "Actualizar":

                    String nom1 = request.getParameter("txtNom");
                    String ape1 = request.getParameter("txtApe");
                    String cedula1 = request.getParameter("txtCedula");
                    String correo1 = request.getParameter("txtCorreo");
                    String nombreUser1 = request.getParameter("txtUser");
                    String estado1 = request.getParameter("txtEstado");
                    String rol1 = request.getParameter("txtRol");

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
                    System.out.println("controller userDB: " + user1);
                    System.out.println("controller corrDB: " + corr1);
                    System.out.println("controller dniiDB: " + dnii1);
                    System.out.println("controller respDB: " + resp1);
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
        }/////
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
                    System.out.println("id before: " + idp);
                    ldao.actualizar(li);
                    request.getRequestDispatcher("controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    ldao.delete(idp);
                    request.getRequestDispatcher("controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    /*
                    String idlibro1 = request.getParameter("txtid");
                    String titulo1 = request.getParameter("txttitulo");
                    String autor1 = request.getParameter("txtautor");
                    String genero1 = request.getParameter("txtgenero");
                    String publicacion1 = request.getParameter("txtpublicacion");
                    int cantidad1 = Integer.parseInt(request.getParameter("txtcantidad"));
                    
                    li.setTitulo(idlibro1);
                    li.setTitulo(titulo1);
                    li.setAutor(autor1);
                    li.setGenero(genero1);
                    li.setPublicacion(publicacion1);
                    li.setCantidad_disponible(cantidad1);
                    
                    li.setId_libro(idp);
                    System.out.println("id before: " + idp);
                    ldao.agregar(li);
                    
                    request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
                    */
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
