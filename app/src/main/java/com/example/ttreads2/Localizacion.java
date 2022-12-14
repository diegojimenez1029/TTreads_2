package com.example.ttreads2;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class Localizacion implements LocationListener {

    MapsActivity mapsActivity;
    TextView tvMensaje;

    public MapsActivity getMapsActivity ()
    {return mapsActivity;
    }

    public void setMapsActivity (MapsActivity mapsActivity, TextView tvMensaje) {
        this.mapsActivity = mapsActivity;
        this.tvMensaje=tvMensaje;
    }



    @Override
    public void onLocationChanged(@NonNull Location location) {

        //Este metodo se ejecuta cuando el gps recibe nuevas coordenadas
        String texto ="Mi ubicacion es:\n"
                + "Latitud=" + location.getLatitude() + "\n"
                + "Longitud=" + location.getLongitude();
        tvMensaje.setText(texto);

        mapa(location.getLatitude(),location.getLongitude());

    }

    public void mapa (double lat, double lon){
        // Fragment del mapa

        FragmentMaps fragment = new FragmentMaps();

        Bundle bundle = new Bundle ();
        bundle.putDouble("lat",new Double (lat));
        bundle.putDouble("lon",new Double(lon));
        fragment.setArguments (bundle);

        FragmentManager fragmentManager = getMapsActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add (R.id.fragment, fragment,null);
        fragmentTransaction.commit();

    }

    public void onStatusChanged (String provider,int status, Bundle extras){
        switch (status){
            case LocationProvider.AVAILABLE:
                Log.d("debug","LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug","LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug","LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
        tvMensaje.setText("Gps Activado");
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
        tvMensaje.setText("Gps Desactivado");
    }
}