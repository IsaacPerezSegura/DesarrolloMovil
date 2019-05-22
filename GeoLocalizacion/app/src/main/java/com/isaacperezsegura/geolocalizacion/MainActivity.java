package com.isaacperezsegura.geolocalizacion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

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

    public void getLocation (View view){
        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            this.locationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {

                    if (location != null) {
                        latitud.setText(Double.toString(location.getLatitude()));
                        longitud.setText(Double.toString(location.getLongitude()));

                        Toast.makeText(getApplicationContext(), location.getLatitude() + " --- " + location.getLatitude() , Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "No tenemos ubicación ", Toast.LENGTH_LONG).show();
                        latitud.setText("Nel");
                        longitud.setText("No hay");
                    }
                }
            });
        }
    }

}
