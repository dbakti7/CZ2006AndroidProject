package Boundary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.android.cz2006androidproject.R;

import Control.CustomListAdapter;
import Entity.Plan;

/**
 * This class is used to show the plan in the form of list
 */
public class ScheduleListView extends AppCompatActivity {
    Plan finalPlan = new Plan();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list_view);
        String[] places={"Jurong East Mall","IKEA","Hendersen Waves",
                "Marina Bay","Changi Airport"};

        int logo[]={R.mipmap.sunny,R.mipmap.rainy,R.mipmap.cloudy,R.mipmap.sunny,R.mipmap.rainy};
        ListAdapter theAdapter = new CustomListAdapter(this, places,logo);
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
}