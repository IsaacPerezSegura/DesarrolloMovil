package com.isaacperezsegura.empleados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.isaacperezsegura.empleados.Adapters.AdapterFormViewPager;
import com.isaacperezsegura.empleados.Modelo.MySQLiteOpenHelper;

import java.io.File;

public class Form extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterFormViewPager viewPagerAdapter;

    private View viewPersonal,viewLaboral;
    /*Vistas para obtener lo ingresado*/
    private TextView nombre,apellidoP,apellidoM,telefono,edad,correo,calleN,colonia,ciudad;
    private TextView estado,estadoCivil,nacionalidad;
    private TextView nomina,puesto,rfc,curp,nss,escolaridad;

    private MySQLiteOpenHelper sqlHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new AdapterFormViewPager(this, getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        sqlHelper = new MySQLiteOpenHelper(this, "Directorio", null, 1);
    }
    public void previusActivity(View view){
        super.onBackPressed();
        finish();
    }
    public void insert(View view){
        viewPersonal = viewPagerAdapter.getMyView(0);
        viewLaboral = viewPagerAdapter.getMyView(1);

        nombre = (TextView) viewPersonal.findViewById(R.id.nombre);
        apellidoP = (TextView) viewPersonal.findViewById(R.id.apellidoP);
        apellidoM = (TextView) viewPersonal.findViewById(R.id.apellidoM);
        telefono = (TextView) viewPersonal.findViewById(R.id.telefono);
        edad = (TextView) viewPersonal.findViewById(R.id.edad);
        correo = (TextView) viewPersonal.findViewById(R.id.correo);
        calleN = (TextView) viewPersonal.findViewById(R.id.calleNumero);
        colonia = (TextView) viewPersonal.findViewById(R.id.colonia);
        ciudad = (TextView) viewPersonal.findViewById(R.id.ciudad);
        estado = (TextView) viewPersonal.findViewById(R.id.estado);
        estadoCivil = (TextView) viewPersonal.findViewById(R.id.estadoCivil);
        nacionalidad = (TextView) viewPersonal.findViewById(R.id.nacionalidad);
        //Laboral
        nomina = (TextView) viewLaboral.findViewById(R.id.nomina);
        puesto = (TextView) viewLaboral.findViewById(R.id.puesto);
        rfc = (TextView) viewLaboral.findViewById(R.id.rfc);
        curp = (TextView) viewLaboral.findViewById(R.id.curp);
        nss = (TextView) viewLaboral.findViewById(R.id.nss);
        escolaridad = (TextView) viewLaboral.findViewById(R.id.escolaridad);

        if(nombre.getText().length() == 0 && apellidoP.getText().length() == 0
                && apellidoM.getText().length() == 0 && nomina.getText().length() == 0){
            Toast.makeText(this, "Por favor ingresa los campos requeridos"
                    , Toast.LENGTH_SHORT).show();
            nombre.setText("Por favor ingresa tu nombre");
            nombre.setTextColor(Color.RED);
            apellidoP.setText("Por favor ingresa tu apellido paterno");
            apellidoP.setTextColor(Color.RED);
            apellidoM.setText("Por favor ingresa tu apellido materno");
            apellidoM.setTextColor(Color.RED);
            nomina.setText("Por favor ingresa tu apellido materno");
            nomina.setTextColor(Color.RED);
        }else if(nombre.getText().length() ==0){
            nombre.setText("Por favor ingresa tu nombre");
            nombre.setTextColor(Color.RED);
        }else if(apellidoP.getText().length() == 0){
            apellidoP.setText("Por favor ingresa tu apellido paterno");
            apellidoP.setTextColor(Color.RED);
        }else if(apellidoM.getText().length() == 0){
            apellidoM.setText("Por favor ingresa tu apellido materno");
            apellidoM.setTextColor(Color.RED);
        }else if(nomina.getText().length() == 0){
            nomina.setText("Por favor ingresa tu apellido materno");
            nomina.setTextColor(Color.RED);
        }else{
            db = sqlHelper.getWritableDatabase();
            ContentValues newRegistry = new ContentValues();
            newRegistry.put("nombre",nombre.getText().toString());
            newRegistry.put("apellidoP",apellidoP.getText().toString());
            newRegistry.put("apellidoM",apellidoM.getText().toString());
            newRegistry.put("telefono",telefono.getText().toString());
            newRegistry.put("edad",edad.getText().toString());
            newRegistry.put("correo",correo.getText().toString());
            newRegistry.put("calleN",calleN.getText().toString());
            newRegistry.put("colonia",colonia.getText().toString());
            newRegistry.put("ciudad",ciudad.getText().toString());
            newRegistry.put("estado",estado.getText().toString());
            newRegistry.put("estadoCivil",estadoCivil.getText().toString());
            newRegistry.put("nacionalidad",nacionalidad.getText().toString());

            newRegistry.put("nomina",nomina.getText().toString());
            newRegistry.put("puesto",puesto.getText().toString());
            newRegistry.put("rfc",rfc.getText().toString());
            newRegistry.put("curp",curp.getText().toString());
            newRegistry.put("nss",nss.getText().toString());
            newRegistry.put("escolaridad",escolaridad.getText().toString());

            db.insert("empleado",null,newRegistry);
            db.close();
            Toast.makeText(this, "Registro realizado", Toast.LENGTH_SHORT).show();
        }
    }
    public void borrar(){
        File file = new File(getDatabasePath("Directorio").getAbsolutePath());
        file.delete();
    }
}
