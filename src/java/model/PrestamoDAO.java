/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import config.conexion;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;

/**
 *
 * @author Jhon
 */
public class PrestamoDAO {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Prestamo buscar(int id) {
        Prestamo pr = new Prestamo();

        String sql = "select * from prestamo where id_prestamo = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Captura los datos de la BD
                pr.setId_prestamo(rs.getInt(1));
                pr.setId_libro(rs.getInt(2));
                pr.setId_usuario(rs.getInt(3));
                pr.setFecha_inicio(rs.getString(4));
                pr.setFecha_limite(rs.getString(5));
                pr.setFecha_entrega(rs.getString(6));
                pr.setRetraso_dias(rs.getInt(7));
                pr.setId_empleado_presta(rs.getInt(8));
                pr.setId_empleado_recibe(rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println("Error BuscarPr: " + e.getMessage());
        }
        return pr;
    }

    //Operaciones CRUD
    public List listar() {
        String sql = "select * from prestamo";
        List<Prestamo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo pr = new Prestamo();
                pr.setId_prestamo(rs.getInt(1));
                pr.setId_libro(rs.getInt(2));
                pr.setId_usuario(rs.getInt(3));
                pr.setFecha_inicio(rs.getString(4));
                pr.setFecha_limite(rs.getString(5));
                pr.setFecha_entrega(rs.getString(6));
                pr.setRetraso_dias(rs.getInt(7));
                pr.setId_empleado_presta(rs.getInt(8));
                pr.setId_empleado_recibe(rs.getInt(9));

                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error ListarPr: " + e.getMessage());
        }
        return lista;
    }

    public Prestamo listarId(int id) {
        Prestamo pr = new Prestamo();
        String sql = "SELECT * FROM prestamo WHERE id_prestamo=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//ejecuta la consulta
            while (rs.next()) {
                pr.setId_prestamo(rs.getInt(1));
                pr.setId_libro(rs.getInt(2));
                pr.setId_usuario(rs.getInt(3));
                pr.setFecha_inicio(rs.getString(4));
                pr.setFecha_limite(rs.getString(5));
                pr.setFecha_entrega(rs.getString(6));
                pr.setRetraso_dias(rs.getInt(7));
                pr.setId_empleado_presta(rs.getInt(8));
                pr.setId_empleado_recibe(rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println("Error ListarIdLi: " + e.getMessage());
        }
        return pr;
    }

    public Prestamo listarIdUser(int id) {
        Prestamo pr = new Prestamo();
        String sql = "SELECT * FROM prestamo WHERE id_usuario = " + id;
        try {
            con = cn.Conexion(); // Assume you have a method to get a connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId_prestamo(rs.getInt(1));
                pr.setId_libro(rs.getInt(2));
                pr.setId_usuario(rs.getInt(3));
                pr.setFecha_inicio(rs.getString(4));
                pr.setFecha_limite(rs.getString(5));
                pr.setFecha_entrega(rs.getString(6));
                pr.setRetraso_dias(rs.getInt(7));
                pr.setId_empleado_presta(rs.getInt(8));
                pr.setId_empleado_recibe(rs.getInt(9));
            }
            return pr; // Se agrega la declaración de retorno aquí
        } catch (Exception e) {
            System.out.println("Error ListarIdUserPrestamo: " + e.getMessage());
            // Manejo del error
        }
        return pr; // También se agrega una declaración de retorno aquí, para asegurarse de que se devuelve un valor en caso de error
    }

    public int agregarPrestamo(Prestamo pe) {
        String sql = "insert into prestamo(id_libro,id_usuario,fecha_inicio, fecha_limite, "
                + "fecha_entrega,retraso_dias,id_empleado_presta,id_empleado_recibe) "
                + "values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getId_libro());
            ps.setInt(2, pe.getId_usuario());
            ps.setString(3, pe.getFecha_inicio());
            ps.setString(4, pe.getFecha_limite());
            ps.setString(5, pe.getFecha_entrega());
            ps.setInt(6, pe.getRetraso_dias());
            ps.setInt(7, pe.getId_empleado_presta());
            ps.setInt(8, pe.getId_empleado_recibe());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Insertar Prestamo: " + e.getMessage());
        }
        return r;
    }

    public int actualizarStock(int idLibro) {
        int cantidad = 0;
        String sql1 = "select cantidad_disponible from libro where id_libro=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, idLibro);
            rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1) - 1; // Restar una unidad
            }
        } catch (SQLException e) {
            System.out.println("Error stock: " + e.getMessage());
        }

        String sql2 = "update libro set cantidad_disponible=? where id_libro=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql2);

            ps.setInt(1, cantidad);
            ps.setInt(2, idLibro);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ActualizarStock Libro: " + e.getMessage());
        }
        return cantidad;
    }

    public int actualizar(Prestamo pe) {
        String sql = "update prestamo set id_libro=?, id_usuario=?, fecha_inicio=?, "
                + "fecha_limite=?, fecha_entrega=?, retraso_dias=?, id_empleado_presta=?, "
                + "id_empleado_recibe=? where id_prestamo=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getId_libro());
            ps.setInt(2, pe.getId_usuario());
            ps.setString(3, pe.getFecha_inicio());
            ps.setString(4, pe.getFecha_limite());
            ps.setString(5, pe.getFecha_entrega());
            ps.setInt(6, pe.getRetraso_dias());
            ps.setInt(7, pe.getId_empleado_presta());
            ps.setInt(8, pe.getId_empleado_recibe());
            ps.setInt(9, pe.getId_prestamo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Actualizar Prestamo: " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from prestamo where id_prestamo=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Delete Prestamo: " + e.getMessage());
        }
    }

    public void generarInforme(HttpServletResponse response, List<Prestamo> prestamos) {
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=InformePrestamos.pdf");

            ServletOutputStream out = response.getOutputStream();
            Document document = new Document(PageSize.LETTER);
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();

            // Obtener la fecha y hora actual
            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fechaFormateada = fechaActual.format(formatter);

            // Crear la fuente para la fecha
            Font dateFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

            // Crear el párrafo para la fecha
            Paragraph fecha = new Paragraph("Fecha de generación: " + fechaFormateada, dateFont);

            // Configurar el formato del título
            Paragraph title = new Paragraph("Informe de Prestamos");
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.setSpacingAfter(20);

            // Agregar título y fecha al documento
            document.add(title);
            document.add(fecha);

            // Crear la tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(9); //n columnas
            table.setWidthPercentage(100);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);

            //Encabezados de columna
            table.addCell("ID PRES");
            table.addCell("ID LIBRO");
            table.addCell("ID USER");
            table.addCell("F. INICIO");
            table.addCell("F. LIMITE");
            table.addCell("F. ENTREGA");
            table.addCell("RETRASO(DIAS)");
            table.addCell("EMP ENTREGA");
            table.addCell("EMP RECIBE");

            // Rellenar la tabla con los datos de los libros
            for (Prestamo prestamo : prestamos) {
                table.addCell(String.valueOf(prestamo.getId_prestamo()));
                table.addCell(String.valueOf(prestamo.getId_libro()));
                table.addCell(String.valueOf(prestamo.getId_usuario()));
                table.addCell(String.valueOf(prestamo.getFecha_inicio()));
                table.addCell(String.valueOf(prestamo.getFecha_limite()));
                table.addCell(String.valueOf(prestamo.getFecha_entrega()));
                table.addCell(String.valueOf(prestamo.getRetraso_dias()));
                table.addCell(String.valueOf(prestamo.getId_empleado_presta()));
                table.addCell(String.valueOf(prestamo.getId_empleado_recibe()));
            }

            // Añadir la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();
            writer.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

}
