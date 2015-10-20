package boundary;

import android.app.Activity;
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

import Control.TravelPlannerAdapter;

/**
 * Created by stvalxndr on 20-Oct-15.
 */

public class TravelPlanner extends Activity {
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travelplanner_layout);
        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        dp.setCalendarViewShown(false);
        date = dp.toString();
        int imgplaces[]={R.mipmap.sunny,R.mipmap.rainy,R.mipmap.cloudy,R.mipmap.sunny,R.mipmap.rainy};
        String places[] = {"Jurong East Mall","IKEA","Hendersen Waves",
                "Marina Bay","Changi Airport"};

        ListAdapter tpAdapter = new TravelPlannerAdapter(this, places, imgplaces);
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

    public void nextStep() {
        /*to do when next is clicked*/
    }

    public void locationPlanner() {
        /*to call location planner class*/
    }

}
