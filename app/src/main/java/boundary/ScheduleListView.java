package boundary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.cz2006androidproject.R;

import java.lang.reflect.Array;
import java.util.List;

import control.CustomListAdapter;
import entity.Location;
import entity.Plan;
import entity.SQLiteHelper;

/**
 * This class is used to show the plan in the form of list
 */
public class ScheduleListView extends AppCompatActivity {
    Plan finalPlan = new Plan();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list_view);

        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List<Location> list = db.getPopularPlaces();

        Bundle extras = getIntent().getExtras();
        String currentCondition;
        int[] curDate = extras.getIntArray("date");
        String[] places = extras.getStringArray("locationList");
        int placesWeather[] = new int[Array.getLength(places)];
        int j;
        for(int i = 0;i<Array.getLength(places);++i) {
            for(j = 0;j<list.size();++j)
                if(places[i].equals(list.get(j).getName()))
                    break;
            list.get(j).setWeatherDetails(accessGovAPI.getNowcast(), accessGovAPI.get12HourForecast());
            currentCondition = list.get(j).getWeather().getCondition();
            if (currentCondition.contains("Cloudy") || currentCondition.contains("Partly Cloudy"))
                placesWeather[i] = R.mipmap.cloudy;
            else if (currentCondition.contains("Hazy"))
                placesWeather[i] = R.mipmap.hazy;
            else if (currentCondition.contains("Fair (Day)") || currentCondition.contains("Fair (Night)"))
                placesWeather[i] = R.mipmap.sunny;
            else if (currentCondition.contains("Thundery showers"))
                placesWeather[i] = R.mipmap.stormy;
            else
                placesWeather[i] = R.mipmap.rainy;
        }
        ListAdapter theAdapter = new CustomListAdapter(this, places, placesWeather);
        ListView theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(theAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule_list_view, menu);
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
    public void editPlan() {

    }

    public void buttonClicked(View view)
    {
        Button btn = (Button) view.findViewById(R.id.button1);
        ImageView IV = (ImageView) view.findViewById(R.id.imageView1);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        List<Location> list = db.getPopularPlaces();
        db.close();
        String placeName = (String)btn.getText();
        int i;
        for(i = 0;i<list.size();++i) {
            if(placeName.equals(list.get(i).getName()))
                break;
        }
        if(i < list.size()) {
            list.get(i).setWeatherDetails(accessGovAPI.getNowcast(), accessGovAPI.get12HourForecast());
            Intent intent = new Intent(ScheduleListView.this, ViewDetails.class);
            intent.putExtra("name", list.get(i).getName());
            intent.putExtra("image", list.get(i).getImage());
            intent.putExtra("condition", list.get(i).getWeather().getCondition());
            intent.putExtra("temperature", list.get(i).getWeather().getTemperature());
            Toast toast = Toast.makeText(getApplicationContext(), list.get(i).getWeather().getTemperature(), Toast.LENGTH_SHORT);
            toast.show();
            intent.putExtra("humidity", list.get(i).getWeather().getHumidity());
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "No Details Available", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}