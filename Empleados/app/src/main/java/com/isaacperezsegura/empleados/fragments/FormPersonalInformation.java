package com.isaacperezsegura.empleados.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaacperezsegura.empleados.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormPersonalInformation extends Fragment {
    private View view;

    public FormPersonalInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_form_personal_information, container, false);
        return view;
    }
    public View getMyView(){
        return view;
    }
}
