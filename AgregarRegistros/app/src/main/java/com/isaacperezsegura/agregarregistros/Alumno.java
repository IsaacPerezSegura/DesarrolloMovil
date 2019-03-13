package com.isaacperezsegura.agregarregistros;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;

    public Alumno (String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}
