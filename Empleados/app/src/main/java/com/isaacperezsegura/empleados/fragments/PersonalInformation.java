package com.isaacperezsegura.empleados.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isaacperezsegura.empleados.Modelo.Employee;
import com.isaacperezsegura.empleados.R;

public class PersonalInformation extends Fragment {
    private TextView nombre,apellidoP,apellidoM,telefono,edad,correo,calleN,colonia,ciudad;
    private TextView estado,estadoCivil,nacionalidad;
    private Employee employee;
    private View view;

    public PersonalInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_personal_information, container, false);
        buildViews();
        return view;

    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public void buildViews(){
        nombre = (TextView) view.findViewById(R.id.nombre);
        apellidoP = (TextView) view.findViewById(R.id.apellidoP);
        apellidoM = (TextView) view.findViewById(R.id.apellidoM);
        telefono = (TextView) view.findViewById(R.id.telefono);
        edad = (TextView) view.findViewById(R.id.edad);
        correo = (TextView) view.findViewById(R.id.correo);
        calleN = (TextView) view.findViewById(R.id.calleNumero);
        colonia = (TextView) view.findViewById(R.id.colonia);
        ciudad = (TextView) view.findViewById(R.id.ciudad);

        estado = (TextView) view.findViewById(R.id.estado);
        estadoCivil = (TextView) view.findViewById(R.id.estadoCivil);
        nacionalidad = (TextView) view.findViewById(R.id.nacionalidad);

        nombre.setText(employee.getNombre());
        apellidoP.setText(employee.getApellidoP());
        apellidoM.setText(employee.getApellidoM());
        telefono.setText(employee.getTelefono());
        edad.setText(String.valueOf(employee.getEdad()));
        correo.setText(employee.getCorreo());
        calleN.setText(employee.getCalle()+" #");
        colonia.setText(employee.getColonia());
        ciudad.setText(employee.getCiudad());
        estado.setText(employee.getEstado());
        estadoCivil.setText(employee.getEstadoCivil());
        nacionalidad.setText(employee.getNacionalidad());
    }
}
