package com.example.android.cz2006androidproject;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class TabHostSchedule extends TabActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_schedule);
        tabHost = getTabHost();

        TabHost.TabSpec ts1 = tabHost.newTabSpec("page1");
        ts1.setIndicator("List View");
        ts1.setContent(new Intent(this, displayListView.class));
        tabHost.addTab(ts1);
        TabHost.TabSpec ts2 = tabHost.newTabSpec("page2");
        ts2.setIndicator("ETC");
        ts2.setContent(new Intent(this, calendar.class));
        tabHost.addTab(ts2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_host_schedule, menu);
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
