package com.isaacperezsegura.empleados.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaacperezsegura.empleados.Modelo.Employee;
import com.isaacperezsegura.empleados.R;

public class FormLaboralInformation extends Fragment {
    private Employee employee;
    private View view;
    public FormLaboralInformation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_form_laboral_information, container, false);
        return view;
    }
    public View getMyView(){
        return view;
    }

}
