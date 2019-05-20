package com.isaacperezsegura.usorestfullaravel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isaacperezsegura.usorestfullaravel.Model.Propietario;
import com.isaacperezsegura.usorestfullaravel.PropietarioVista;
import com.isaacperezsegura.usorestfullaravel.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolderDatos> {
    private ArrayList<Propietario> propietarios;
    private Context contexto;

    public RecycleViewAdapter(Context contexto, ArrayList<Propietario> propietarios){
        this.contexto = contexto;
        this.propietarios = propietarios;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.element, viewGroup, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        final int o = i;
        viewHolderDatos.asignarDatos(propietarios.get(i));
        viewHolderDatos.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(contexto, PropietarioVista.class);
                intent.putExtra("propietario",propietarios.get(o));
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return propietarios.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idPropietario;
        TextView nombre;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idPropietario = (TextView) itemView.findViewById(R.id.id);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
        }
        public void asignarDatos(Propietario propietario){
            idPropietario.setText(String.valueOf(propietario.getId()));
            nombre.setText(propietario.getNombre());
        }
    }
}
