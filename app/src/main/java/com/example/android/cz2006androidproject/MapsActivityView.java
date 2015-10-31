package com.example.android.cz2006androidproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivityView extends FragmentActivity implements OnMapReadyCallback {
    private final LatLng Jurong_EAST = new LatLng(1.33313,103.743402);
    private final LatLng IKEA_Tampines = new LatLng(1.374095,103.932354);
    private final LatLng HENDERSEN_WAVES = new LatLng(1.276095,103.815444);
    private final LatLng Changi_airport = new LatLng(1.36442,103.991531);
    private final LatLng Marina_bay_sands = new LatLng(1.2838785,103.8589899);
    private GoogleMap map ;
    private final LatLng Center_SGP = new LatLng(1.2800945,103.8509491);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_activity_view);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions().position(Jurong_EAST).title("Jurong East Mall"));
        map.addMarker(new MarkerOptions().position(IKEA_Tampines).title("IKEA"));
        map.addMarker(new MarkerOptions().position(HENDERSEN_WAVES).title("Hendersen Waves"));
        map.addMarker(new MarkerOptions().position(Changi_airport).title("Changi Airport"));
        map.addMarker(new MarkerOptions().position(Marina_bay_sands).title("Marina Bay Sands"));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(Center_SGP,10);
        map.animateCamera(update);
        // Add a marker in Sydney and move the camera
    }
}
