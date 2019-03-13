package com.isaacperezsegura.agregarregistros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Formulario extends AppCompatActivity {
    private Alumno alumno;
    private EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        textView = (EditText) findViewById(R.id.input);
    }
    public void registrar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("informacion", textView.getText().toString());
        startActivity(intent);
    }
}
