/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jhon
 */
public class Libro {
    int id_libro;
    String titulo;
    String autor;
    String genero;
    String publicacion;
    int cantidad_disponible;
    
    public Libro(){
        
    }

    public Libro(int id_libro, String titulo, String autor, String genero, String publicacion, int cantidad_disponible) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicacion = publicacion;
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
    
}
