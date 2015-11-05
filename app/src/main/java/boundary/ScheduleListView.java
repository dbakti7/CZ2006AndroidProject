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
import control.TravelPlannerAdapter;
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
        int[] curDate = extras.getIntArray("date");
        String[] places = extras.getStringArray("locationList");
        //dp.updateDate(curDate[0], curDate[1], curDate[2]);
        int weatherPlaces[] = new int[Array.getLength(places)];
        for(int i = 0;i<Array.getLength(places);++i) {
            for(int j = 0;j<list.size();++j)
                if(places[i].equals(list.get(j).getName()))
                    break;
            weatherPlaces[i] = R.mipmap.cloudy;
        }
        //int imgplaces[]={R.mipmap.sunny,R.mipmap.rainy,R.mipmap.cloudy,R.mipmap.sunny,R.mipmap.rainy};

        //int logo[]={R.mipmap.sunny,R.mipmap.rainy,R.mipmap.cloudy,R.mipmap.sunny,R.mipmap.rainy};
        ListAdapter theAdapter = new CustomListAdapter(this, places,weatherPlaces);
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
            Intent intent = new Intent(ScheduleListView.this, ViewDetails.class);
            intent.putExtra("name", list.get(i).getName());
            intent.putExtra("description", list.get(i).getDescription());
            intent.putExtra("image", list.get(i).getImage());
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "No Details Available", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}