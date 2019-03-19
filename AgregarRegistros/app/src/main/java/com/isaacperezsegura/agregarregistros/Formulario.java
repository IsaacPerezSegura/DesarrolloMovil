package com.isaacperezsegura.agregarregistros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

public class Formulario extends AppCompatActivity {
    private ArrayList<Alumno> alumno;
    private EditText textView;
    private Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        textView = (EditText) findViewById(R.id.input);
        main = new Intent(this, MainActivity.class);
        if(getIntent().hasExtra("lista_alumnos")) {
            alumno = (ArrayList<Alumno>) getIntent().getSerializableExtra("lista_alumnos");
        }
    }
    public void registrar(View view){
        alumno.add(new Alumno(textView.getText().toString()));
        main.putExtra("lista_alumnos", alumno);
        startActivity(main);
    }
    public void cancelar(View view){
        main.putExtra("lista_alumnos", alumno);
        startActivity(main);
    }
}
