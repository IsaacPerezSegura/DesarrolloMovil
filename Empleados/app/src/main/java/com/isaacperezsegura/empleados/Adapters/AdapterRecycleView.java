package com.isaacperezsegura.empleados.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.isaacperezsegura.empleados.Modelo.Employee;
import com.isaacperezsegura.empleados.InformacionPrincipal;
import com.isaacperezsegura.empleados.R;

import java.util.ArrayList;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolderDatos> {
    private ArrayList<Employee> employeeList;
    private Context contexto;

    public AdapterRecycleView(Context contexto, ArrayList<Employee> employeeList){
        this.employeeList = employeeList;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.list, viewGroup, false);
        return new ViewHolderDatos(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        final int o=i;
        viewHolderDatos.asignarDatos(employeeList.get(i));
        viewHolderDatos.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, InformacionPrincipal.class);
                intent.putExtra("employee",employeeList.get(o));
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nombre;
        TextView nomina;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            nomina = (TextView) itemView.findViewById(R.id.nomina);
        }
        public void asignarDatos(Employee employee){
            nombre.setText(employee.getNombre()+""+employee.getApellidoP()+" "+employee.getApellidoM());
            nomina.setText(employee.getNomina());
        }
    }
}
