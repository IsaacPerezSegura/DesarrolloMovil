package com.isaacperezsegura.navegacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Secondary extends AppCompatActivity {
    private static Alumno alumno;
    private TextView argumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        argumento = (TextView) findViewById(R.id.argumento);
        argumento.setText("Nombre: "+alumno.getNombre()+"\n Edad: "+alumno.getEdad());
    }
    public static void setAlumno(Alumno student){
        alumno = student;
    }
}
