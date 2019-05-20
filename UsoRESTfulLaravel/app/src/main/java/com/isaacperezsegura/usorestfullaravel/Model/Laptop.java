package com.isaacperezsegura.usorestfullaravel.Model;

import java.io.Serializable;

public class Laptop implements Serializable {
    private String modelo;
    private String marca;
    private int id;
    private int idPropietario;

    public Laptop(String modelo, String marca, int id, int idPropietario) {
        this.modelo = modelo;
        this.marca = marca;
        this.id = id;
        this.idPropietario = idPropietario;
    }
    public Laptop(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }
    public Laptop() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}
