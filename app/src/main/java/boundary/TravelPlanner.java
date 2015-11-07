package boundary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.cz2006androidproject.R;

import java.lang.reflect.Array;
import java.util.List;

import control.PlanGenerator;
import control.TravelPlannerAdapter;
import entity.Location;
import entity.Plan;
import entity.SQLiteHelper;

/**
 * Created by stvalxndr on 20-Oct-15.
 * This class is used to arrange places selected by user.
 */

public class TravelPlanner extends Activity {
    Location[] listLocation = new Location[10];
    DatePicker dp;
    private int[] curDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_planner);
        dp = (DatePicker)findViewById(R.id.datePicker);
        dp.setCalendarViewShown(false);

        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List <Location> list = db.getPopularPlaces();

        Bundle extras = getIntent().getExtras();
        curDate = extras.getIntArray("date");
        String[] places = extras.getStringArray("locationList");
        dp.updateDate(curDate[0], curDate[1], curDate[2]);

        int placesWeather[] = new int[Array.getLength(places)];
        String currentCondition;
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


        ListAdapter tpAdapter = new TravelPlannerAdapter(this, places, placesWeather);
        ListView lvtp = (ListView)findViewById(R.id.lvtp);
        lvtp.setAdapter(tpAdapter);
        lvtp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String Placekicked = "Detail" +
                        String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(TravelPlanner.this, Placekicked, Toast.LENGTH_SHORT).show();

            }
        });

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
    public void addButtonClicked(View view) {
        Intent intent = new Intent(TravelPlanner.this, SearchView.class);
        curDate[0] = dp.getYear();
        curDate[1] = dp.getMonth();
        curDate[2] = dp.getDayOfMonth();
        intent.putExtra("date", curDate);
        startActivity(intent);
    }
    public void nextStep() {
        /*to do when next is clicked*/
    }

    public void locationPlanner(View view) {
        /*to call location planner class*/
        Intent intent = new Intent(TravelPlanner.this, ScheduleTabSwitch.class);

        PlanGenerator planGenerator = new PlanGenerator();

        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        planGenerator.generatePlan(db.getCurrentPlan(), dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
        Plan currentPlan = planGenerator.getGeneratedPlan();

        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int day = java.util.Calendar.getInstance().get(java.util.Calendar.DATE);
        if(db.getPlan(currentPlan.getDate()) == null) {
            if(curDate[0] < year || (curDate[0] == year && curDate[1] < month) ||
                    (curDate[0] == year && curDate[1] == month && curDate[2] < day))
                Toast.makeText(TravelPlanner.this, "Invalid date!", Toast.LENGTH_SHORT).show();
            else if(currentPlan.getLocationCount() == 0)
                Toast.makeText(TravelPlanner.this, "Empty Plan!", Toast.LENGTH_SHORT).show();
            else {
                db.addPlan(currentPlan);
                List<Location> list2 = db.getCurrentPlan();
                for (Location l : list2)
                    db.deleteLocationFromCurrentPlan(l);
                db.close();
                int[] date = curDate;
                intent.putExtra("locationList", currentPlan.getlocationList());
                intent.putExtra("date", date);
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(TravelPlanner.this, "Plan already exists!", Toast.LENGTH_SHORT).show();
        }

    }

}
