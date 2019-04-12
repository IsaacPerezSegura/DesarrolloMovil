package com.isaacperezsegura.empleados.Modelo;

import java.io.Serializable;

public class Employee implements Serializable {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String edad;
    private String nacionalidad;
    private String correo;
    private String calle;

    private String colonia;
    private String ciudad;
    private String estado;
    private String estadoCivil;
    private String puesto;
    private String curp;
    private String nss;
    private String nomina;
    private String rfc;
    private String escolaridad;


    public Employee(String nombre, String apellidoP, String apellidoM, String nomina) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.nomina = nomina;
    }

    public String getEscolaridad() {
        if(escolaridad.length() == 0){
            escolaridad = "Sin informacion";
        }
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getRfc() {
        if(rfc.length() == 0){
            rfc = "Sin informacion";
        }
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNacionalidad() {
        if(nacionalidad.length() == 0){
            nacionalidad = "Sin informacion";
        }
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEdad() {
        if(edad.length() == 0){
            edad = "Sin informacion";
        }
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        if(telefono.length() == 0){
            telefono = "Sin informacion";
        }
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        if(correo.length() == 0){
            correo = "Sin informacion";
        }
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCalle()
    {
        if(calle.length() == 0){
            calle = "Sin informacion";
        }
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        if(colonia.length() == 0){
            colonia = "Sin informacion";
        }
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        if(ciudad.length() == 0){
            ciudad = "Sin informacion";
        }
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado()
    {
        if(estado.length() == 0){
            estado = "Sin informacion";
        }
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoCivil()
    {
        if(estadoCivil.length() == 0){
            estadoCivil = "Sin informacion";
        }
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getPuesto()
    {
        if(puesto.length() == 0){
            puesto = "Sin informacion";
        }
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCurp() {
        if(curp.length() == 0){
            curp = "Sin informacion";
        }
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss()
    {
        if(nss.length() == 0){
            nss = "Sin informacion";
        }
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNomina() {
        if(nomina.length() == 0){
            nomina = "Sin informacion";
        }
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }
}