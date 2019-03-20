package com.example.aplicaciones3.practicageolocalizacion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LocationManager lm;
    LocationProvider lp;
    Location l;
    LocationListener ls;
    TextView t1, t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        lp = lm.getProvider(LocationManager.GPS_PROVIDER);
        final boolean st = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        t1=findViewById(R.id.text1);
        t2=findViewById(R.id.text2);


        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "NO ESTA ACTIVO EL GPS", Toast.LENGTH_SHORT);
            return;
        }


        ls = new LocationListener()
        {

            @Override
            public void onLocationChanged(Location location)
            {
                t1.setText(String .valueOf(location.getLatitude()));
                t2.setText(String .valueOf(location.getLongitude()));


            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras)
            {


            }

            @Override
            public void onProviderEnabled(String provider)
            {

            }

            @Override
            public void onProviderDisabled(String provider)
            {



            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "ESTOY DENTRO DEL IF PRRO", Toast.LENGTH_SHORT);
            return;
        }

        //tiempo y distancia en metros0
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ls);


    }







}
