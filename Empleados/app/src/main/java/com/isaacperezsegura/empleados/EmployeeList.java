package com.isaacperezsegura.empleados;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.isaacperezsegura.empleados.Adapters.AdapterRecycleView;
import com.isaacperezsegura.empleados.Modelo.Employee;
import com.isaacperezsegura.empleados.Modelo.MySQLiteOpenHelper;

import java.util.ArrayList;

public class EmployeeList extends AppCompatActivity {
    private EditText searchBar;
    private RecyclerView recyclerView;
    private AdapterRecycleView adaptador;

    private ArrayList<Employee> listEmployee;
    private MySQLiteOpenHelper sqlhelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        searchBar = (EditText) findViewById(R.id.searchBar);

        recyclerView = (RecyclerView) findViewById(R.id.employeesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //Realizar select from
        sqlhelper = new MySQLiteOpenHelper(this, "Directorio", null,1);
        getData();
    }
    public void getData(){
        listEmployee = new ArrayList<>();
        db = sqlhelper.getWritableDatabase();
        Cursor fila = db.rawQuery("select nombre,apellidoP,apellidoM,nomina,telefono" +
                ",edad,correo,calleN,colonia,ciudad,estado,estadoCivil,nacionalidad,nomina" +
                ",puesto,rfc,curp,nss,escolaridad from empleado",null);
        Employee e = null;
        while(fila.moveToNext()){
            e = new Employee(fila.getString(0).toString()
                    ,fila.getString(1).toString()
                    ,fila.getString(2).toString()
                    ,fila.getString(3).toString());
            e.setTelefono(fila.getString(4).toString());
            e.setEdad(fila.getString(5).toString());
            e.setCorreo(fila.getString(6).toString());
            e.setCalle(fila.getString(7).toString());
            e.setColonia(fila.getString(8).toString());
            e.setCiudad(fila.getString(9).toString());
            e.setEstado(fila.getString(10).toString());
            e.setEstadoCivil(fila.getString(11).toString());
            e.setNacionalidad(fila.getString(12).toString());
            e.setNomina(fila.getString(13).toString());
            e.setPuesto(fila.getString(14).toString());
            e.setRfc(fila.getString(15).toString());
            e.setCurp(fila.getString(16).toString());
            e.setNss(fila.getString(17).toString());
            e.setEscolaridad(fila.getString(18).toString());
            listEmployee.add(e);
        }
        db.close();
        adaptador = new AdapterRecycleView(this,listEmployee);
        recyclerView.setAdapter(adaptador);
    }
    public void searchEmployee(View view){
        if(searchBar.getText().length()>0){
        listEmployee = new ArrayList<>();
        db = sqlhelper.getWritableDatabase();
        Cursor fila = db.rawQuery("select nombre,apellidoP,apellidoM,nomina,telefono" +
                ",edad,correo,calleN,colonia,ciudad,estado,estadoCivil,nacionalidad,nomina" +
                ",puesto,rfc,curp,nss,escolaridad " +
                        "from empleado where nomina='"+searchBar.getText()+"'"
                ,null);
        Employee e = null;
        while(fila.moveToNext()) {
            e = new Employee(fila.getString(0).toString()
                    , fila.getString(1).toString()
                    , fila.getString(2).toString()
                    , fila.getString(3).toString());
            e.setTelefono(fila.getString(4).toString());
            e.setEdad(fila.getString(5).toString());
            e.setCorreo(fila.getString(6).toString());
            e.setCalle(fila.getString(7).toString());
            e.setColonia(fila.getString(8).toString());
            e.setCiudad(fila.getString(9).toString());
            e.setEstado(fila.getString(10).toString());
            e.setEstadoCivil(fila.getString(11).toString());
            e.setNacionalidad(fila.getString(12).toString());
            e.setNomina(fila.getString(13).toString());
            e.setPuesto(fila.getString(14).toString());
            e.setRfc(fila.getString(15).toString());
            e.setCurp(fila.getString(16).toString());
            e.setNss(fila.getString(17).toString());
            e.setEscolaridad(fila.getString(18).toString());
            listEmployee.add(e);
            db.close();
            adaptador = new AdapterRecycleView(this, listEmployee);
            recyclerView.setAdapter(adaptador);

        }
        }else{getData();}
    }
    public void previusActivity(View view){
        super.onBackPressed();
        finish();
    }
}
