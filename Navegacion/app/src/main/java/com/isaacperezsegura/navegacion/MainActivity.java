package com.isaacperezsegura.navegacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private Alumno alumno;
    Serializable s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);;
        alumno = new Alumno("Isaac", 22);
    }
    public void changeActivity(View view){
        Intent intent = new Intent(this, Secondary.class);
        Secondary.setAlumno(alumno);
        
        intent.putExtra(alumno.toString(),s);
        startActivity(intent);
    }
}
