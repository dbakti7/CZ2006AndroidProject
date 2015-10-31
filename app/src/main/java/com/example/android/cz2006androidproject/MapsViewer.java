package com.example.android.cz2006androidproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsViewer extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
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
        setContentView(R.layout.activity_maps_viewer);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions().position(Jurong_EAST).title("Jurong East Mall"));
        map.addMarker(new MarkerOptions().position(IKEA_Tampines).title("IKEA"));
        map.addMarker(new MarkerOptions().position(HENDERSEN_WAVES).title("Hendersen Waves"));
        map.addMarker(new MarkerOptions().position(Changi_airport).title("Changi Airport"));
        map.addMarker(new MarkerOptions().position(Marina_bay_sands).title("Marina Bay Sands"));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(Center_SGP, 10);
        map.animateCamera(update);
        // Add a marker in Sydney and move the camera
    }
}
