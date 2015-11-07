package boundary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.android.cz2006androidproject.R;

import java.util.ArrayList;
import java.util.List;

import control.CustomListAdapter;
import entity.Location;
import entity.SQLiteHelper;


public class PlacesListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list_view);

        Bundle extras = getIntent().getExtras();
        String category = extras.getString("parse this");
        List<String> placesList = new ArrayList<String>();
        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List<Location> list = db.getPopularPlaces();
        int placesWeather[] = new int[5];;
        int counter = 0;
        String currentCondition;
        for(int i = 0;i<list.size();++i) {
            if (list.get(i).getCategory().equals(category)) {
                placesList.add(list.get(i).getName());
                list.get(i).setWeatherDetails(accessGovAPI.getNowcast(), accessGovAPI.get12HourForecast());
                currentCondition = list.get(i).getWeather().getCondition();
                if (currentCondition.contains("Cloudy") || currentCondition.contains("Partly Cloudy"))
                    placesWeather[counter++] = R.mipmap.cloudy;
                else if (currentCondition.contains("Hazy"))
                    placesWeather[counter++] = R.mipmap.hazy;
                else if (currentCondition.contains("Fair (Day)") || currentCondition.contains("Fair (Night)"))
                    placesWeather[counter++] = R.mipmap.sunny;
                else if (currentCondition.contains("Thundery showers"))
                    placesWeather[counter++] = R.mipmap.stormy;
                else
                    placesWeather[counter++] = R.mipmap.rainy;
            }
        }

        String[] places = new String[placesList.size()];
        places = placesList.toArray(places);

        ListAdapter theAdapter = new CustomListAdapter(this, places, placesWeather);
        final ListView theListView = (ListView) findViewById(R.id.placesListView);
        theListView.setAdapter(theAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_places_list_view, menu);
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
    public void buttonClicked(View view)
    {
        Button btn = (Button) view.findViewById(R.id.button1);
        ImageView IV = (ImageView) view.findViewById(R.id.imageView1);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        List<Location> list = db.getPopularPlaces();
        String placeName = (String)btn.getText();
        for(int i = 0;i<list.size();++i) {
            if(placeName.equals(list.get(i).getName())) {
                Location location = new Location();
                location.setName(list.get(i).getName());
                location.setCategory(list.get(i).getCategory());
                location.setPos(list.get(i).getLatitude(), list.get(i).getLongitude());
                location.setImage("test");
                location.setDescription("description");
                db.addLocationToCurrentPlan(location);
                btn.setText("Place Added");
            }
        }

    }


}
