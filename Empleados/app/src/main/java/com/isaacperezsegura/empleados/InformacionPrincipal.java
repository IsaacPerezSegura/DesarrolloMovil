package com.isaacperezsegura.empleados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.isaacperezsegura.empleados.Modelo.Employee;

public class InformacionPrincipal extends AppCompatActivity {
    private TextView nombre;
    private TextView apellidoP;
    private TextView apellidoM;
    private TextView nomina;
    private TextView telefono,puesto;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_principal);
        nombre = (TextView) findViewById(R.id.nombre);
        apellidoP = (TextView) findViewById(R.id.apellidoP);
        apellidoM = (TextView) findViewById(R.id.apellidoM);
        nomina = (TextView) findViewById(R.id.nomina);
        telefono = (TextView) findViewById(R.id.telefono);
        puesto = (TextView) findViewById(R.id.puesto);

        employee = (Employee)this.getIntent().getSerializableExtra("employee");
        nombre.setText(employee.getNombre());
        apellidoP.setText(employee.getApellidoP());
        apellidoM.setText(employee.getApellidoM());
        nomina.setText(employee.getNomina());
        telefono.setText(employee.getTelefono());
        puesto.setText(employee.getPuesto());

    }
    public void goToCompleteInformation(View view){
        Intent intent = new Intent(this, CompleteInformation.class);
        intent.putExtra("employee",employee);
        startActivity(intent);
    }
    public void previusActivity(View view){
       super.onBackPressed();
       finish();
    }
}
