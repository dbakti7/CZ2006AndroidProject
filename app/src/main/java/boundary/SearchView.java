package boundary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.android.cz2006androidproject.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;


import com.example.android.placeapiautocomplete.PlaceArrayAdapter;

import java.util.List;
import entity.Location;
import entity.SQLiteHelper;

public class SearchView extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,
GoogleApiClient.ConnectionCallbacks {
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private AutoCompleteTextView mAutocompleteTextView;
    private GoogleApiClient mGoogleApiClient;
    private PlaceArrayAdapter mPlaceArrayAdapter;
    private static final LatLngBounds BOUNDS_SINGAPORE = new LatLngBounds(
            new LatLng(1.196938, 103.625473), new LatLng(1.469376, 104.018237));

    private Location picked;
    private int[] curDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        Bundle extras = getIntent().getExtras();
        curDate = extras.getIntArray("date");
        picked = null;
        mGoogleApiClient = new GoogleApiClient.Builder(SearchView.this)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID, this)
                .addConnectionCallbacks(this)
                .build();
        mAutocompleteTextView = (AutoCompleteTextView) findViewById(R.id
                .autoCompleteTextView);
        mAutocompleteTextView.setThreshold(3);
        mAutocompleteTextView.setOnItemClickListener(mAutocompleteClickListener);
        mPlaceArrayAdapter = new PlaceArrayAdapter(this, android.R.layout.simple_list_item_1,
                BOUNDS_SINGAPORE, null);
        mAutocompleteTextView.setAdapter(mPlaceArrayAdapter);
    }

    private AdapterView.OnItemClickListener mAutocompleteClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final PlaceArrayAdapter.PlaceAutocomplete item = mPlaceArrayAdapter.getItem(position);
            final String placeId = String.valueOf(item.placeId);
            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);

        }
    };

    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(PlaceBuffer places) {

            if (!places.getStatus().isSuccess()) {
                return;
            }
            // Selecting the first object buffer.
            final Place place = places.get(0);
            try {
                picked = new Location((String)place.getName(),place.getLatLng().latitude,place.getLatLng().longitude);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onConnected(Bundle bundle) {
        mPlaceArrayAdapter.setGoogleApiClient(mGoogleApiClient);

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        Toast.makeText(this,
                "Google Places API connection failed with error code:" +
                        connectionResult.getErrorCode(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mPlaceArrayAdapter.setGoogleApiClient(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Move to CalendarPage
    public void calendarPageClicked(View view) {
        Intent intent = new Intent(SearchView.this, Calendar.class);
        startActivity(intent);
    }

    //Move to HomePage
    public void homePageClicked(View view) {
        Intent intent = new Intent(SearchView.this, MainActivity.class);
        ActivityCompat.finishAffinity(this);
        startActivity(intent);
    }
    String getUserInput(){
        return null;
    }

    public void touristAttractionsClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Tourist Attractions");
        startActivity(intent);
    }
    public void hotelsClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Hotels");
        startActivity(intent);
    }
    public void foodCentresClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Food Centres");
        startActivity(intent);
    }
    public void parksClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Parks");
        startActivity(intent);
    }
    public void museumClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Museums");
        startActivity(intent);
    }
    public void publicLibrariesClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Public Libraries");
        startActivity(intent);
    }

    public void searchEntry(String entry) {

    }

    public void addButtonClicked(View view) {
        Intent intent = new Intent(SearchView.this, TravelPlanner.class);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        List<Location> list = db.getCurrentPlan();
        String[] locationList = new String[list.size()];
        for(int i = 0;i<list.size();++i)
            locationList[i] = list.get(i).getName();

        db.close();
        int year = curDate[0];
        int month = curDate[1];
        int day = curDate[2];
        int[] date = {year, month, day};
        intent.putExtra("locationList", locationList);
        intent.putExtra("date", date);
        startActivity(intent);
    }
    public void deleteButtonClicked(View view) {
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        List<Location> list = db.getCurrentPlan();
        for(Location l: list)
            db.deleteLocationFromCurrentPlan(l);
        db.close();
    }
    public void addPlaceFromSearch(View view) {
        AutoCompleteTextView ACTV = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        if(picked != null && (BOUNDS_SINGAPORE.contains(new LatLng(picked.getLatitude(), picked.getLongitude())))) {
            SQLiteHelper db = new SQLiteHelper(this);
            db.getWritableDatabase();
            db.addLocationToOtherPlaces(picked);
            db.addLocationToCurrentPlan(picked);
            db.close();
            ACTV.setText("");
            Toast toast = Toast.makeText(getApplicationContext(), "Place Added", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Place", Toast.LENGTH_SHORT);
            toast.show();
            ACTV.setText("");
        }
    }
}
