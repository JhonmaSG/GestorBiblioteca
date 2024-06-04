/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Movimiento {
    int id_movimiento;
    int id_prestamo;
    int id_libro;
    int id_usuario;
    String nombre;
    String cedula;
    String titulo;

    public Movimiento() {
    }

    public Movimiento(int id_movimiento, int id_prestamo, int id_libro, int id_usuario, String nombre, String cedula, String titulo) {
        this.id_movimiento = id_movimiento;
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.titulo = titulo;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
