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

/**
 *
 * @author Jhon
 */
public class VentaDAO {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroSerie = "";
        String sql = "select max(NumeroSerie) from ventas";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while( rs.next() ){
                numeroSerie = rs.getString(1);    
            }
        } catch (SQLException e){
            System.out.println("Error GenerarSerie: " + e.getMessage());
        }
        return numeroSerie;
    }
    
    public String IdVentas(){
        String idVentas="";
        String sql = "select max(IdVentas) from ventas";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while( rs.next() ){
                idVentas = rs.getString(1);    
            }
        } catch (SQLException e){
            System.out.println("Error IdVentas: " + e.getMessage());
        }
        return idVentas;
    }
    
    public int guardarVenta(Venta ve){
        String sql = "insert into ventas(IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado)value(?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,ve.getIdcliente());
            ps.setInt(2,ve.getIdempleado());
            ps.setString(3,ve.getNumSerie());
            ps.setString(4,ve.getFecha());
            ps.setDouble(5,ve.getPrecio());
            ps.setString(6,ve.getEstado());
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error GuardarVenta: " + e.getMessage());
        }
        return r;
    }
    
    public int guardarDetalleVentas(Venta venta){
        String sql = "insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,venta.getId());
            ps.setInt(2,venta.getIdproducto());
            ps.setInt(3,venta.getCantidad());
            ps.setDouble(4,venta.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error GuardarDetalleVentas: " + e.getMessage());
        }
        return r;
    }
}
