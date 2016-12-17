package com.example.p437.mapp;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

 //   private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
       /* // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/


        StreetViewPanoramaFragment streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.map);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
  /*  @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }*/

    public void onClick(View view)
    {

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        if(Num.rand==1)streetViewPanorama.setPosition(new LatLng(20.6825124,-88.5687889));
        if(Num.rand==2)streetViewPanorama.setPosition(new LatLng(55.755,37.6188999));
        if(Num.rand==3)streetViewPanorama.setPosition(new LatLng(31.5881971,74.3106033));
        if(Num.rand==4)streetViewPanorama.setPosition(new LatLng(37.5778861,126.9769658));
        if(Num.rand==5)streetViewPanorama.setPosition(new LatLng(51.5005644,-0.1223387));
        if(Num.rand==6)streetViewPanorama.setPosition(new LatLng(32.8061684,130.706393));
        if(Num.rand==7)streetViewPanorama.setPosition(new LatLng(25.195232,55.276428));
        if(Num.rand==8)streetViewPanorama.setPosition(new LatLng(45.4328051,12.3405832));
        if(Num.rand==9)streetViewPanorama.setPosition(new LatLng(29.9803885,31.1329825));
        if(Num.rand==10)streetViewPanorama.setPosition(new LatLng(27.1743042,78.0419975));
    }
}
