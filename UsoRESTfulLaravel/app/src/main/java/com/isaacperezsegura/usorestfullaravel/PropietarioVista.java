package com.isaacperezsegura.usorestfullaravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.isaacperezsegura.usorestfullaravel.Adapter.RecycleViewAdapter;
import com.isaacperezsegura.usorestfullaravel.Model.Laptop;
import com.isaacperezsegura.usorestfullaravel.Model.Propietario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PropietarioVista extends AppCompatActivity {
    private EditText nombre;
    private TextView id;
    private TextView laptop;
    private Button actualizar;
    private Button borrar;
    private Propietario propietario;
    private Laptop laptopModel;
    private JsonArrayRequest request;
    private JsonObjectRequest putRequest;
    private RequestQueue requestQueue;

    private final String URL = "http://10.54.1.210:8000";
    private final String apiPropietario = "/api/propietario/";
    private final String apiLaptop = "/api/laptop/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propietario_vista);
        nombre = (EditText) findViewById(R.id.nombre);
        id = (TextView) findViewById(R.id.id);
        laptop = (TextView) findViewById(R.id.laptop);
        propietario = (Propietario)getIntent().getSerializableExtra("propietario");

        id.setText(String.valueOf(propietario.getId()));
        nombre.setText(propietario.getNombre());
        Log.d("error_server","segundo activity");
        requestQueue = Volley.newRequestQueue(this);
        request = new JsonArrayRequest(Request.Method.GET, URL + apiLaptop+String.valueOf(propietario.getId()),null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getLaptop(response);
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_server",error.toString());
            }
        });
        requestQueue.add(request);
    }
    public void update(View view){
        String jsonRequest = "{'nombre': '"+nombre.getText().toString()+"'}";
        Map<String, String> parametros = new HashMap<>();
        parametros.put("nombre", nombre.getText().toString());

        putRequest = new JsonObjectRequest(Request.Method.PUT, URL + apiPropietario+String.valueOf(propietario.getId()),new JSONObject(parametros)
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    nombre.setText(response.getString("nombre"));
                }catch(Exception e){
                    Log.d("error",e.getMessage());
                }
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_server",error.toString());
            }
        });
        requestQueue.add(putRequest);
    }
    public void delete(View view){
        putRequest = new JsonObjectRequest(Request.Method.DELETE, URL + apiPropietario+String.valueOf(propietario.getId()),null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_server",error.toString());
            }
        });
        requestQueue.add(putRequest);
        putRequest = new JsonObjectRequest(Request.Method.DELETE, URL + apiLaptop+String.valueOf(propietario.getId()),null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_server",error.toString());
            }
        });
        requestQueue.add(putRequest);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void getLaptop(JSONArray objects){
        try{
            JSONObject object= (JSONObject) objects.get(0);
            laptopModel = new Laptop(
                    object.getString("modelo"),
                    object.getString("marca")
                );
            laptop.setText(laptopModel.getMarca()+" "+laptopModel.getModelo());
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }finally {

        }
    }
}
