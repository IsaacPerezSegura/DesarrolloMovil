package com.isaacperezsegura.agregarregistros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show);
        show.setText(getIntent().getStringExtra("informacion"));
    }

    public void changeActivity (View view){
        Intent intent = new Intent(this, Formulario.class);
        startActivity(intent);
    }
}
