package boundary;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.android.cz2006androidproject.MapsViewer;
import com.example.android.cz2006androidproject.R;



public class ScheduleTabSwitch extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_tab_switch);

        TabHost tabHost = getTabHost();
        Bundle extras = getIntent().getExtras();
        int[] date = extras.getIntArray("date");
        String[] locationList = extras.getStringArray("locationList");
        Intent ListIntent = new Intent(this, ScheduleListView.class);

        ListIntent.putExtra("locationList", locationList);
        ListIntent.putExtra("date", date);
        TabHost.TabSpec spec;
        spec = tabHost.newTabSpec("page1").setIndicator("list").setContent(ListIntent);
        tabHost.addTab(spec);
        TextView tv = (TextView) findViewById(R.id.dateInPlan);
        tv.setText(String.valueOf(date[2]) + "/" + String.valueOf(date[1]) + "/" + String.valueOf(date[0]));
        Intent MapIntent = new Intent(this, MapsViewer.class);
        MapIntent.putExtra("locationList", locationList);
        MapIntent.putExtra("date", date);
        spec = tabHost.newTabSpec("page2").setIndicator("map").setContent(MapIntent);
        tabHost.addTab(spec);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule_tab_switch, menu);
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
}