/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "select * from libro where id_libro=" + id;
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
            System.out.println("Error ListarIdPr: " + e.getMessage());
        }
        return li;
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
                + "(id_libro, titulo, autor, genero, publicacion, cantidad_disponible)"
                + "values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, li.getId_libro());
            ps.setString(2, li.getTitulo());
            ps.setString(3, li.getAutor());
            ps.setString(4, li.getGenero());
            ps.setString(5, li.getPublicacion());
            ps.setInt(6, li.getCantidad_disponible());
            
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
}
