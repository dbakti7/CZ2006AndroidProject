package boundary;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

<<<<<<< HEAD:app/src/main/java/boundary/ScheduleTabSwitch.java
import com.example.android.cz2006androidproject.R;

=======
import boundary.MapView;
import boundary.ScheduleListView;
import boundary.MainActivity;
import boundary.Calendar;
>>>>>>> 9b3a1016d46f499f7ab2cdba93590a66806aaae5:app/src/main/java/com/example/android/cz2006androidproject/ScheduleTabSwitch.java


public class ScheduleTabSwitch extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_tab_switch);

        TabHost tabHost = getTabHost();

        Intent ListIntent = new Intent(this, ScheduleListView.class);
        TabHost.TabSpec spec;
        spec = tabHost.newTabSpec("page1").setIndicator("list").setContent(ListIntent);
        tabHost.addTab(spec);

        Intent MapIntent = new Intent(this, MapsActivityView.class);
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