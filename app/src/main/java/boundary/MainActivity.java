package boundary;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;

import com.example.android.cz2006androidproject.R;
import java.util.List;

import control.LocationPlanner;
import entity.Location;
import entity.SQLiteHelper;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();

        ListView listview;
        ArrayAdapter<String> listAdapter;

        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int day = java.util.Calendar.getInstance().get(java.util.Calendar.DATE);
        String dateString = String.valueOf(year) + String.valueOf(month) + String.valueOf(day);
        String[] currentPlan = {"No travel plan for today."};
        if(db.getPlan(dateString) != null)
            currentPlan = db.getPlan(dateString);
        db.close();
        listview = (ListView)findViewById(R.id.listview);
        listAdapter = new ArrayAdapter<String>(this, R.layout.myplan_layout, R.id.textView2, currentPlan);
        listview.setAdapter(listAdapter);
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

    //Move to SearchPage
    public void searchPage(View view) {
        Intent intent = new Intent(MainActivity.this, SearchView.class);
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int day = java.util.Calendar.getInstance().get(java.util.Calendar.DATE);
        int[] date = {year, month, day};
        intent.putExtra("date", date);
        startActivity(intent);
    }

    //Move to Calendar Page
    public void calendarPageClicked(View v){
        startActivity(new Intent(MainActivity.this, Calendar.class));
    }

    public void recommendedPlanClicked(View view) {
        LocationPlanner locationPlanner = new LocationPlanner();
        Intent intent = new Intent(MainActivity.this, TravelPlanner.class);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        List <Location> list = db.getRecommendedPlan();
        List <Location> list2 = db.getCurrentPlan();
        for(Location l: list2)
            locationPlanner.removePlaceFromCurrentPlan(l, this.getApplicationContext());
        for(Location l: list)
            locationPlanner.addPlaceFromPopularPlaces(l, this.getApplicationContext());
        String[] locationList = new String[list.size()];
        for(int i = 0;i<list.size();++i)
            locationList[i] = list.get(i).getName();
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int day = java.util.Calendar.getInstance().get(java.util.Calendar.DATE);
        int[] date = {year, month, day};
        intent.putExtra("locationList", locationList);
        intent.putExtra("date", date);
        startActivity(intent);
    }

    public void staffPickedClicked(View view) {
        LocationPlanner locationPlanner = new LocationPlanner();
        Intent intent = new Intent(MainActivity.this, TravelPlanner.class);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List <Location> list = db.getStaffPicked();
        List <Location> list2 = db.getCurrentPlan();
        for(Location l: list2)
            locationPlanner.removePlaceFromCurrentPlan(l, this.getApplicationContext());
        for(Location l: list)
            locationPlanner.addPlaceFromPopularPlaces(l, this.getApplicationContext());
        String[] locationList = new String[list.size()];
        for(int i = 0;i<list.size();++i)
            locationList[i] = list.get(i).getName();
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int day = java.util.Calendar.getInstance().get(java.util.Calendar.DATE);
        int[] date = {year, month, day};
        intent.putExtra("locationList", locationList);
        intent.putExtra("date", date);
        startActivity(intent);
    }

}
