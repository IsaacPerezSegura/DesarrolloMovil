package com.isaacperezsegura.usorestfullaravel.Model;

import java.io.Serializable;

public class Propietario implements Serializable {
    private String nombre;
    private int id;
    private Laptop laptop;

    public Propietario(int id,String nombre) {
        this.id=id;
        this.nombre = nombre;
    }
    public Propietario(String nombre, int id, Laptop laptop) {
        this.nombre = nombre;
        this.id = id;
        this.laptop = laptop;
    }
    public Propietario(){

    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
