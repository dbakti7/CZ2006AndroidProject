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

import java.lang.reflect.Array;
import java.util.List;

import entity.Location;
import entity.SQLiteHelper;

public class MapsViewer extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private GoogleMap map ;
    private final LatLng Center_SGP = new LatLng(1.2800945,103.8509491);
    private LatLng[] coordinatesList;
    private String[] places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_viewer);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List<Location> list = db.getPopularPlaces();
        List<Location> listOther = db.getOtherPlaces();
        Bundle extras = getIntent().getExtras();
        int[] curDate = extras.getIntArray("date");
        places = extras.getStringArray("locationList");
        coordinatesList = new LatLng[Array.getLength(places)];
        int weatherPlaces[] = new int[Array.getLength(places)];
        for(int i = 0;i<Array.getLength(places);++i) {
            boolean flag = false;
            for(int j = 0;j<list.size();++j)
                if(places[i].equals(list.get(j).getName())) {
                    coordinatesList[i] = new LatLng(list.get(j).getLatitude(), list.get(j).getLongitude());
                    flag = true;
                    break;
                }
            if(!flag) {
                for(int j = 0;j<listOther.size();++j)
                    if(places[i].equals(listOther.get(j).getName())) {
                        coordinatesList[i] = new LatLng(listOther.get(j).getLatitude(), listOther.get(j).getLongitude());
                        break;
                    }
            }
            weatherPlaces[i] = R.mipmap.sunny;
        }
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
    }
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        for(int i = 0;i<Array.getLength(coordinatesList);++i)
            map.addMarker(new MarkerOptions().position(coordinatesList[i]).title(places[i]));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(Center_SGP, 10);
        map.animateCamera(update);
    }
}
