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

import model.Cliente;
import model.ClienteDAO;
import model.Empleado;
import model.EmpleadoDAO;
import model.Producto;
import model.ProductoDAO;
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

    Cliente cl = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int idc;

    Producto pr = new Producto();
    ProductoDAO pdao = new ProductoDAO();
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
            usuario = (Empleado) sesion.getAttribute("usuario");
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        

        //Empleado Biblioteca
        if (menu.equals("Empleado")) {
            request.setAttribute("usuario", usuario);
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNom");
                    String tel = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    String password = request.getParameter("txtPassword");

                    String passEncriptada = encriptar(password);
                    //System.out.println("contra encriptada Controlador: " + passEncriptada);

                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(estado);
                    em.setUser(user);
                    em.setPassword(passEncriptada);

                    edao.agregar(em);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNom");
                    String tel1 = request.getParameter("txtTel");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(estado1);
                    em.setUser(user1);

                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    System.out.println("id before:" + request.getParameter("id"));
                    ide = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    System.out.println("id before:" + ide);
                    System.out.println("ide: " + ide);
                    edao.delete(ide);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    System.out.println("Error Default switch ");
                    throw new AssertionError();
            }
        }
        //Cliente Usuario
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNom");
                    String dir = request.getParameter("txtDir");
                    String estado = request.getParameter("txtEstado");
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(dir);
                    cl.setEs(estado);
                    cdao.agregar(cl);
                    request.getRequestDispatcher("controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNom");
                    String dir1 = request.getParameter("txtDir");
                    String estado1 = request.getParameter("txtEstado");
                    cl.setDni(dni1);
                    cl.setNom(nom1);
                    cl.setDir(dir1);
                    cl.setEs(estado1);

                    cl.setId(idc);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    cdao.delete(idc);
                    request.getRequestDispatcher("controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    System.out.println("Error Default switch Cliente");
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        //Libros
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNom");
                    double pre = Double.parseDouble(request.getParameter("txtPre"));
                    int st = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    pr.setNom(nom);
                    pr.setPre(pre);
                    pr.setStock(st);
                    pr.setEstado(est);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pl = pdao.listarId(idp);
                    request.setAttribute("producto", pl);
                    break;
                case "Actualizar":
                    System.out.println("id before: " + idp);
                    //idp = Integer.parseInt(request.getParameter("id"));
                    String nom1 = request.getParameter("txtNom");
                    Double pre1 = Double.valueOf(request.getParameter("txtPre"));
                    int st1 = Integer.parseInt(request.getParameter("txtStock"));
                    String estado1 = request.getParameter("txtEstado");
                    pr.setId(idp);
                    pr.setNom(nom1);
                    pr.setPre(pre1);
                    pr.setStock(st1);
                    pr.setEstado(estado1);

                    pdao.actualizar(pr);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        //Nuevo Prestamo
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    //Estamos enviando el parametro a la claseDAO para que buscar el cliente de dese dni
                    cl.setDni(dni);

                    cl = cdao.buscar(dni);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroSerie);
                    break;
                case "BuscarProducto":
                    int id = parseInt(request.getParameter("codigoproducto"));
                    pr = pdao.listarId(id);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroSerie);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalP);
                    break;
                case "AgregarProducto":
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroSerie);
                    totalP = 0.0;
                    item = item + 1;
                    cod = pr.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;

                    v = new Venta();    //Resetear valores
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cantidad);
                    v.setSubtotal(subtotal);

                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalP += lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalP);
                    //setAttribute(atributo, lista de los datos);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idProducto = lista.get(i).getIdproducto();
                        //Ejecutar el método buscar
                        ProductoDAO pDAO = new ProductoDAO();
                        pr = pDAO.buscar(idProducto);//Método buscar: nos da el producto que contiene ese ID
                        //Captura el Stock actual
                        int stockActual = pr.getStock() - cantidad;
                        pDAO.actualizarStock(idProducto, stockActual);
                    }
                    //Guardar Venta
                    v.setIdcliente(cl.getId());
                    v.setIdempleado(2);
                    v.setNumSerie(numeroSerie);
                    v.setFecha("2023-10-16");
                    v.setMonto(totalP);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //Guardar Detalle ventas
                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVentas(v);
                    }
                    break;
                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalP = 0;

                    //numeroSerie: Almacena el num maximo del numero de serie de esta en la BD
                    numeroSerie = vdao.GenerarSerie();
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                        request.setAttribute("nserie", numeroSerie);
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie(); //Instanciar la clase generarSerie
                        numeroSerie = gs.NumeroSerie(incrementar);//Enviar el numeroSerie al formulario
                        request.setAttribute("nserie", numeroSerie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

        if (menu.equals("Ayuda")) {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Ayuda.jsp").forward(request, response);
        }

    }

    private String asegurarClave(String clave) {
        String claveSHA = null;

        try {
            //Instanciamos el tipo de Hash
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            //Pasaa: clave a bytes
            sha256.update(clave.getBytes());
            claveSHA = Base64.getEncoder().encodeToString(sha256.digest());
        } catch (Exception ex) {
            System.out.println("ERROR to SHA256\n" + ex);
        }
        return claveSHA;
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
