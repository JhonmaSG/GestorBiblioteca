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

public class MovimientoDAO {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    //Operaciones CRUD
    public List listar() {
        String sql = "select * from movimientousuarios";
        List<Movimiento> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movimiento pr = new Movimiento();
                pr.setId_movimiento(rs.getInt(1));
                pr.setId_prestamo(rs.getInt(2));
                pr.setId_libro(rs.getInt(3));
                pr.setId_usuario(rs.getInt(4));
                pr.setNombre(rs.getString(5));
                pr.setNombre(rs.getString(6));
                pr.setTitulo(rs.getString(7));

                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error Listar MovimientoUsuarios: " + e.getMessage());
        }
        return lista;
    }
    
    public void generarInforme(HttpServletResponse response, List<Movimiento> movimientos) {
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=InformeHistorialUsuarios.pdf");

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
            Paragraph title = new Paragraph("Informe de Historial Usuarios");
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
            table.addCell("ID PRESTAMO");
            table.addCell("ID LIBRO");
            table.addCell("ID USER");
            table.addCell("F. INICIO");
            table.addCell("F. LIMITE");
            table.addCell("F. ENTREGA");
            table.addCell("RETRASO(DIAS)");
            table.addCell("EMP ENTREGA");
            table.addCell("EMP RECIBE");

            // Rellenar la tabla con los datos de los libros
            for (Movimiento movimiento : movimientos) {
                table.addCell(String.valueOf(movimiento.getId_movimiento()));
                table.addCell(String.valueOf(movimiento.getId_prestamo()));
                table.addCell(String.valueOf(movimiento.getId_libro()));
                table.addCell(String.valueOf(movimiento.getId_usuario()));
                table.addCell(String.valueOf(movimiento.getNombre()));
                table.addCell(String.valueOf(movimiento.getCedula()));
                table.addCell(String.valueOf(movimiento.getTitulo()));
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
