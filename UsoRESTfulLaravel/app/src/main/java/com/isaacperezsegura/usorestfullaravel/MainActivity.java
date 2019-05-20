package com.isaacperezsegura.usorestfullaravel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.isaacperezsegura.usorestfullaravel.Adapter.RecycleViewAdapter;
import com.isaacperezsegura.usorestfullaravel.Model.Laptop;
import com.isaacperezsegura.usorestfullaravel.Model.Propietario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView list;
    private RecycleViewAdapter adapter;
    private ArrayList<Propietario> propietarios;
    private Propietario propietario;
    private final String URL = "http://10.54.1.210:8000";
    private final String apiPropietario = "/api/propietario/";
    private final String apiLaptop = "/api/laptop";
    private RequestQueue requestQueue;
    private JsonArrayRequest request;
    private Context context;
    private JsonObjectRequest jsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getList();
    }

    public void getList(){
        requestQueue = Volley.newRequestQueue(this);
        request = new JsonArrayRequest(Request.Method.GET, URL + apiPropietario+"all",null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("error_server","jajjaja");
                getPropietarios(response);
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_server",error.toString());
            }
        });
        requestQueue.add(request);
    }
    public void getPropietarios(JSONArray object){
        try{
             propietarios = new ArrayList();
            for (int i=0;i<object.length();i++){
                JSONObject prop = object.getJSONObject(i);
                propietario = new Propietario(
                        prop.getInt("id"),
                        prop.getString("nombre")
                );
                propietarios.add(propietario);
            }
        }catch(Exception e){
            Log.e("error",e.getMessage());
       }finally {

        }
        adapter = new RecycleViewAdapter(this,propietarios);
        list.setAdapter(adapter);
    }
}
