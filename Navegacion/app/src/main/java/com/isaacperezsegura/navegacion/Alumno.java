package com.isaacperezsegura.navegacion;

public class Alumno {
    private String nombre;
    private int edad;

    public Alumno (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }
}
