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
public class UsuarioDAO {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Usuario validar(String user, String clave) {
        Usuario us = new Usuario();
        String sql = "select * from usuario where nombre_usuario=? and contraseña=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, clave);
            //System.out.println("Userrrr: "+user);
            //System.out.println("Claveeee: "+clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setNombre_user(rs.getString("nombre_usuario"));
                us.setCedula(rs.getString("cedula"));
                us.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error ValidarUser: " + e.getMessage());
        }
        return us;
    }

    /*public boolean validarPassword(String usuario, String clave){
        String sql = "select Password from empleado where User ="+usuario;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            String pass = rs.getString(7);
            System.out.println("Pazz: "+pass);
            
            
        } catch(SQLException e){
           System.out.println("Error ListarEmp: "+ e.getMessage());
        }
        
        return false;
    }*/
    public Usuario buscar(int cedula) {
        Usuario u = new Usuario();
        String sql = "select * from usuario where cedula=" + cedula;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //c = Entidad Empleado
                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setContraseña(rs.getString(4));
                u.setRespuesta(rs.getString(5));
                u.setCedula(rs.getString(5));
                u.setNombre_user(rs.getString(5));
                u.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error BuscarUser: " + e.getMessage());
        }
        return u;
    }

    //Operaciones CRUD
    public List listar() {
        String sql = "select * from usuario";
        List<Usuario> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setContraseña(rs.getString(4));
                us.setRespuesta(rs.getString(5));
                us.setCedula(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setNombre_user(rs.getString(8));
                us.setEstado(rs.getString(9));
                us.setRol(rs.getString(10));

                lista.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo ListarUser: " + ex.getMessage());
        }
        return lista;
    }

    public Usuario listarId(int id) {
        Usuario us = new Usuario();
        String sql = "select * from usuario where id_usuario=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//ejecuta la consulta
            while (rs.next()) {
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setCedula(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setNombre_user(rs.getString(8));
                us.setEstado(rs.getString(9));
                us.setRol(rs.getString(10));

            }
        } catch (SQLException e) {
            System.out.println("Error ListarIdUser: " + e.getMessage());
        }
        return us;
    }

    public int actualizar(Usuario us) {
        String sql = "update usuario set nombre=?, apellido=?, cedula=?, correo=?, nombre_usuario=?, estado=?, rol=? where id_usuario=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getCedula());
            ps.setString(4, us.getCorreo());
            ps.setString(5, us.getNombre_user());
            ps.setString(6, us.getEstado());
            ps.setString(7, us.getRol());
            ps.setInt(8, us.getId_usuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ActualizarUser: " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from usuario where id_usuario=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error DeleteUser: " + e.getMessage());
        }
    }

    public boolean validarPassword(String usuario, String clave) {
        String sql = "select Password from empleado where User =" + usuario;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            String pass = rs.getString(7);
            System.out.println("Pazz: " + pass);

        } catch (SQLException e) {
            System.out.println("Error ListarEmp: " + e.getMessage());
        }

        return false;
    }

    public int insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, apellido, contraseña, respuesta_contra, cedula, correo, nombre_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getRespuesta());
            ps.setString(5, usuario.getCedula());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getNombre_user());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error Insertar User: " + e.getMessage());

        }
        return r;
    }

    public boolean recuperarContraseña(Usuario us, String contraNueva) {
        String sql = "SELECT nombre_usuario, correo, cedula, respuesta_contra "
                + "FROM Usuario WHERE nombre_usuario = ? AND correo = ? AND cedula = ? AND respuesta_contra = ?";
        String sql2 = "UPDATE Usuario SET contraseña = ? WHERE cedula = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre_user());
            ps.setString(2, us.getCorreo());
            ps.setString(3, us.getCedula());
            ps.setString(4, us.getRespuesta());
            rs = ps.executeQuery();

            if (rs.next()) {
                String userDB = rs.getString("nombre_usuario");
                String corrDB = rs.getString("correo");
                String dniiDB = rs.getString("cedula");
                String respDB = rs.getString("respuesta_contra");
                System.out.println("dao userDB: " + userDB);
                System.out.println("dao corrDB: " + corrDB);
                System.out.println("dao dniiDB: " + dniiDB);
                System.out.println("dao respDB: " + respDB);

                if (userDB.equals(us.getNombre_user())
                        && corrDB.equals(us.getCorreo())
                        && dniiDB.equals(us.getCedula())
                        && respDB.equals(us.getRespuesta())) {
                    ps = con.prepareStatement(sql2);
                    ps.setString(1, contraNueva); // Establece la nueva contraseña
                    ps.setString(2, us.getCedula()); // Utiliza la cédula para identificar al usuario
                    System.out.println("Contra nueva: " + contraNueva);
                    System.out.println("cedula: " + dniiDB);
                    ps.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error recuperarContraseña User: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }

        }
        return false;
    }
}
