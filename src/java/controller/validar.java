/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import static config.Hash.encriptar;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Empleado;
import model.EmpleadoDAO;
import model.Usuario;
import model.UsuarioDAO;

//Mirar JDK 16.0
//Jhon Serrano
/**
 *
 * @author Jhon
 */
public class validar extends HttpServlet {

    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    
    UsuarioDAO udao = new UsuarioDAO();
    Usuario us = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion.equals("Ingresar")) {
            //Capturar los datos que esta ingresando el usuario
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");

            //String passEncriptada = encriptar(pass);
            //System.out.println("contra encriptada Validar: " + passEncriptada);
            //System.out.println("tamaño String: " + passEncriptada.length());
            
            us = udao.validar(user, pass);
            System.out.println(us.getNombre());
            em = edao.validar(user, pass);
            System.out.println(em.getNom());
            if ( em.getNom()!= null) {//Si trajo algo de la base de datos
                System.out.println("Ingreso Sesion OK");
                HttpSession sesion = request.getSession();
                
                sesion.setAttribute("empleado", em);//clase: "usuario"
                request.getRequestDispatcher("controlador?menu=Principal_Admin")
                        .forward(request, response);
            }
            if ( us.getNombre_user()!= null) {//Si trajo algo de la base de datos
                System.out.println("Ingreso Sesion OK");
                HttpSession sesion = request.getSession();
                
                sesion.setAttribute("usuario", us);//clase: "usuario"
                request.getRequestDispatcher("controlador?menu=Principal")
                        .forward(request, response);
            }else {
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
            }
        } else if(accion.equals("Olvide mi contraseña")){
            request.getRequestDispatcher("RecuperarContra.jsp").forward(request, response);
        } else if(accion.equals("Atras")){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(accion.equals("EnviarRecuperacion")){
            request.getRequestDispatcher("ContraCambiada.jsp").forward(request, response);
        }else if(accion.equals("Crear Cuenta")){
            request.getRequestDispatcher("CrearCuenta.jsp").forward(request, response);
        }else if(accion.equals("Inicio")){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("usuario");
            sesion.invalidate();
            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
