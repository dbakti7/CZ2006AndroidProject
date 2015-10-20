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
import com.example.android.cz2006androidproject.ScheduleListView;
import com.example.android.cz2006androidproject.ViewDetails;

import Entity.Place;
import Entity.Weather;


public class MainActivity extends AppCompatActivity{//ActionBarActivity {

    ListView listview;
    ArrayAdapter<String> listAdapter;
    String[] fragmentArray = {"A","B","C","D","E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView)findViewById(R.id.listview);
        listAdapter = new ArrayAdapter<String>(this, R.layout.myplan_layout, R.id.textView2, fragmentArray);
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
        Intent intent = new Intent(MainActivity.this, search.class);
        startActivity(intent);
    }

    //Move to Calendar Page
    public void calendarPageClicked(View v){
        startActivity(new Intent(MainActivity.this, calendar.class));
    }
    public void placeDetail(View v) {
        Intent i = new Intent(MainActivity.this, ViewDetails.class);
        Place pSample = new Place("Scenery", "Tourist Attractions", new Weather(), "Beautiful Scenery", "landscape_540115_1920");
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

}
