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

/**
 *
 * @author Jhon
 */
public class LibroDAO {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    //Buscara el Id del producto
    public Libro buscar(int id) {
        Libro li = new Libro();

        String sql = "select * from libro where id_libro = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Captura los datos de la BD
                li.setId_libro(rs.getInt(1));
                li.setTitulo(rs.getString(2));
                li.setAutor(rs.getString(3));
                li.setGenero(rs.getString(4));
                li.setPublicacion(rs.getString(5));
                li.setCantidad_disponible(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Error BuscarPr: " + e.getMessage());
        }
        return li;
    }

    //Operaciones CRUD
    public List listar() {
        String sql = "select * from libro";
        List<Libro> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro li = new Libro();
                li.setId_libro(rs.getInt(1));
                li.setTitulo(rs.getString(2));
                li.setAutor(rs.getString(3));
                li.setGenero(rs.getString(4));
                li.setPublicacion(rs.getString(5));
                li.setCantidad_disponible(rs.getInt(6));

                lista.add(li);
            }
        } catch (SQLException e) {
            System.out.println("Error ListarPr: " + e.getMessage());
        }
        return lista;
    }

    public Libro listarId(int id) {
        Libro li = new Libro();
        String sql = "SELECT * FROM libro WHERE id_libro=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//ejecuta la consulta
            while (rs.next()) {
                li.setId_libro(rs.getInt(1));
                li.setTitulo(rs.getString(2));
                li.setAutor(rs.getString(3));
                li.setGenero(rs.getString(4));
                li.setPublicacion(rs.getString(5));
                li.setCantidad_disponible(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Error ListarIdLi: " + e.getMessage());
        }
        return li;
    }

    public List<Libro> listarTitulo(String titulo) {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro WHERE titulo LIKE ?";
        try {
            con = cn.Conexion(); // Assume you have a method to get a connection
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + titulo + "%"); // Using LIKE for partial matches
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId_libro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setPublicacion(rs.getString("publicacion"));
                libro.setCantidad_disponible(rs.getInt("cantidad_disponible"));
                lista.add(libro);
            }
            return lista; // Se agrega la declaración de retorno aquí
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo del error
        }
        return lista; // También se agrega una declaración de retorno aquí, para asegurarse de que se devuelve un valor en caso de error
    }

    public int actualizar(Libro li) {
        String sql = "update libro set titulo=?, autor=?, genero=?, "
                + "publicacion=?, cantidad_disponible=? where id_libro=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, li.getTitulo());
            ps.setString(2, li.getAutor());
            ps.setString(3, li.getGenero());
            ps.setString(4, li.getPublicacion());
            ps.setInt(5, li.getCantidad_disponible());
            ps.setInt(6, li.getId_libro());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ActualizarPr: " + e.getMessage());
        }
        return r;
    }

    public int actualizarStock(int id, int stock) {
        String sql = "update libro set cantidad_disponible=? where id_libro=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, stock);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ActualizarStockPr: " + e.getMessage());
        }
        return r;
    }

    public int agregar(Libro li) {
        String sql = "insert into libro"
                + "(titulo, autor, genero, publicacion, cantidad_disponible)"
                + "values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, li.getTitulo());
            ps.setString(2, li.getAutor());
            ps.setString(3, li.getGenero());
            ps.setString(4, li.getPublicacion());
            ps.setInt(5, li.getCantidad_disponible());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error AgregarLibro: " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from libro where id_libro=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error DeleteLibro: " + e.getMessage());
        }
    }

    public void generarInforme(HttpServletResponse response, List<Libro> libros) {
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=InformeLibros.pdf");

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
            Paragraph title = new Paragraph("Informe de Libros");
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.setSpacingAfter(20);

            // Agregar título y fecha al documento
            document.add(title);
            document.add(fecha);

            // Crear la tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(6); // 6 columnas
            table.setWidthPercentage(100);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);

            // Añadir encabezados de columna
            table.addCell("ID");
            table.addCell("Título");
            table.addCell("Autor");
            table.addCell("Género");
            table.addCell("Publicación");
            table.addCell("Cantidad");

            // Rellenar la tabla con los datos de los libros
            for (Libro libro : libros) {
                table.addCell(String.valueOf(libro.getId_libro()));
                table.addCell(libro.getTitulo());
                table.addCell(libro.getAutor());
                table.addCell(libro.getGenero());
                table.addCell(libro.getPublicacion());
                table.addCell(String.valueOf(libro.getCantidad_disponible()));
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
