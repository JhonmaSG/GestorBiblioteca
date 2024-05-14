/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jhon
 */
public class Empleado {
    int id;
    String dni;
    String nom;
    String tel;
    String estado;
    String user;
    String password;

    public Empleado() {
    }

    public Empleado(int id, String dni, String nom, String tel, String state, String user, String password) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.estado = state;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String state) {
        this.estado = state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
