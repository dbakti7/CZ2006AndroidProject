package boundary;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;

import com.example.android.cz2006androidproject.R;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import entity.Location;
import entity.SQLiteHelper;
import entity.Weather;


public class MainActivity extends AppCompatActivity{//ActionBarActivity {

    List nowcast = new ArrayList();
    private class nowcastAPIHandler extends AsyncTask<String,Void,List> {
        @Override
        protected List doInBackground(String... params) {
            List<List> myReturn = null;
            try {
                String keyref = "781CF461BB6606ADBC7C75BF9D4F60DBD179D04B183282AD";
                String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + params[0] + "&keyref=" + keyref;

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                int responseCode = con.getResponseCode();
                if(responseCode == 200) {
                    control.xmlParser temp = new control.xmlParser();
                    myReturn = temp.parseWeatherXml(con.getInputStream(), params[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return myReturn;
        }

        @Override
        protected void onPostExecute(List result) {
            nowcast = result;
        }
    }

    List forecast12 = new ArrayList();
    private class forecast12APIHandler extends AsyncTask<String,Void,List> {
        @Override
        protected List doInBackground(String... params) {
            List myReturn = null;
            try {
                String keyref = "781CF461BB6606ADBC7C75BF9D4F60DBD179D04B183282AD";
                String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + params[0] + "&keyref=" + keyref;

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                int responseCode = con.getResponseCode();
                if(responseCode == 200) {
                    control.xmlParser temp = new control.xmlParser();
                    forecast12 = temp.parseWeatherXml(con.getInputStream(), params[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("FORECAST12",forecast12.get(0).toString());
            Log.d("FORECAST12",forecast12.get(1).toString());
            Log.d("FORECAST12",forecast12.get(2).toString());
            return myReturn;
        }

        @Override
        protected void onPostExecute(List result) {
            forecast12 = result;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteHelper db = new SQLiteHelper(this);
        new nowcastAPIHandler().execute("nowcast");
        new forecast12APIHandler().execute("12hrs_forecast");
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
    public void placeDetail(View v) throws Exception {
        Intent i = new Intent(MainActivity.this, ViewDetails.class);
        Location pSample = new Location("Scenery", "Tourist Attractions", new Weather(), "Beautiful Scenery", "landscape_540115_1920");
        String[] pSampleArray = new String[10];
        for(int j=0;j<5;++j) {
            pSampleArray[j] = new String();
            pSampleArray[j] = (String)pSample.getDetails().get(j).toString();
        }
        i.putExtra("parse this", pSampleArray);
        startActivity(i);
    }

    public void travelPlannerPage(View view) {
        Intent intent = new Intent(MainActivity.this, TravelPlanner.class);

        startActivity(intent);
    }

    public void recommendedPlanClicked(View view) {
        Intent intent = new Intent(MainActivity.this, TravelPlanner.class);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getWritableDatabase();
        List <Location> list = db.getRecommendedPlan();
        List<Location> list2 = db.getCurrentPlan();
        for(Location l: list2)
            db.deleteLocation(l);
        for(Location l: list)
            db.addLocationtoCurrentPlan(l);
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
        Intent intent = new Intent(MainActivity.this, TravelPlanner.class);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List <Location> list = db.getStaffPicked();
        List<Location> list2 = db.getCurrentPlan();
        for(Location l: list2)
            db.deleteLocation(l);
        for(Location l: list)
            db.addLocationtoCurrentPlan(l);
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
