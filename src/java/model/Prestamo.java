/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jhon
 */
public class Prestamo {
    int id_prestamo;
    int id_libro;
    int id_usuario;
    
    String fecha_inicio;
    String fecha_limite;
    String fecha_entrega;
    int retraso_dias;
    
    int id_empleado_presta;
    int id_empleado_recibe;

    public Prestamo() {
    }

    public Prestamo(Integer id_prestamo, Integer id_libro, Integer id_usuario, String fecha_inicio, String fecha_limite, String fecha_entrega, int retraso_dias, Integer id_empleado_presta, Integer id_empleado_recibe) {
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.id_usuario = id_usuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_limite = fecha_limite;
        this.fecha_entrega = fecha_entrega;
        this.retraso_dias = retraso_dias;
        this.id_empleado_presta = id_empleado_presta;
        this.id_empleado_recibe = id_empleado_recibe;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getRetraso_dias() {
        return retraso_dias;
    }

    public void setRetraso_dias(int retraso_dias) {
        this.retraso_dias = retraso_dias;
    }

    public int getId_empleado_presta() {
        return id_empleado_presta;
    }

    public void setId_empleado_presta(int id_empleado_presta) {
        this.id_empleado_presta = id_empleado_presta;
    }

    public int getId_empleado_recibe() {
        return id_empleado_recibe;
    }

    public void setId_empleado_recibe(int id_empleado_recibe) {
        this.id_empleado_recibe = id_empleado_recibe;
    }

    
}
