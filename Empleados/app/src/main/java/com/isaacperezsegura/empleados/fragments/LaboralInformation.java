package com.isaacperezsegura.empleados.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isaacperezsegura.empleados.Modelo.Employee;
import com.isaacperezsegura.empleados.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaboralInformation extends Fragment {

    private Employee employee;
    private View view;

    private TextView nomina,puesto,rfc,curp,nss,escolaridad;

    public LaboralInformation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_laboral_information, container, false);
        buildViews();
        return view;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public void buildViews(){
        nomina = (TextView) view.findViewById(R.id.nomina);
        puesto = (TextView) view.findViewById(R.id.puesto);
        rfc = (TextView) view.findViewById(R.id.rfc);
        curp = (TextView) view.findViewById(R.id.curp);
        nss = (TextView) view.findViewById(R.id.nss);
        escolaridad = (TextView) view.findViewById(R.id.escolaridad);

        nomina.setText(employee.getNomina());
        puesto.setText(employee.getPuesto());
        rfc.setText(employee.getRfc());
        curp.setText(employee.getCurp());
        nss.setText(employee.getNss());
        escolaridad.setText(employee.getEscolaridad());
    }
}
