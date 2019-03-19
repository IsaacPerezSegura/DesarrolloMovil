package com.isaacperezsegura.agregarregistros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    private EditText busqueda;
    private ArrayList <Alumno> listaAlumno;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show);
        busqueda = (EditText) findViewById(R.id.busqueda);
        listaAlumno = new ArrayList();
        if(getIntent().hasExtra("lista_alumnos")){
            this.listaAlumno = (ArrayList<Alumno>) getIntent().getExtras().getSerializable("lista_alumnos");
        }
        muestra_alumnos();
    }
    public void agregar(View view){
        intent = new Intent(this, Formulario.class);
        intent.putExtra("lista_alumnos",listaAlumno);
        startActivity(intent);
    }
    private void muestra_alumnos(){
        //Validar si hay personas registradas
        if(listaAlumno.isEmpty()) {
            show.setText("No hay alumnos");
        }else{
            String lista = "";
            for (Alumno temp:listaAlumno){
                lista = lista + temp.getNombre()+"\n";
            }
            show.setText(lista);
        }
    }
}
