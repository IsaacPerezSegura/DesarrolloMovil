package com.isaacperezsegura.empleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showList(View view){
        intent = new Intent(this,EmployeeList.class);
        startActivity(intent);
    }
    public void showForm(View view){
        intent = new Intent(this,Form.class);
        startActivity(intent);
    }
}
