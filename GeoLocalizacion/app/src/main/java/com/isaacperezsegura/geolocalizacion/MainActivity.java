package com.isaacperezsegura.geolocalizacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    private TextView longitud;
    private TextView latitud;
    private FusedLocationProviderClient locationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitud = (TextView) findViewById(R.id.longitud);
        latitud = (TextView) findViewById(R.id.latitud);

        locationClient = LocationServices.getFusedLocationProviderClient(this);

    }

    public void getLocation(View view){

    }
}
