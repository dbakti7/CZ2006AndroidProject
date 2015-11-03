package boundary;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cz2006androidproject.R;

import java.util.List;

import entity.Location;
import entity.SQLiteHelper;

/**
 * This class is used to show the search result of an query. User will be able to select places
 * from here.
 */
public class SearchResult extends ActionBarActivity {
    Location[] result = new Location[10];
    String searchEntry = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List<Location> list = db.getCurrentPlan();


        TextView tester=(TextView)findViewById(R.id.testerTextView1);

        /*try {
            loc.setWeatherDetails();
            tester.setText(loc.getWeather().toString());
        }
        catch(Exception e) {

        }*/
        Location location = list.get(0);
        try {
            location.setWeatherDetails();
            tester.setText(location.getWeather().toString());
        }
        catch(Exception e) {
            //Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
            //toast.show();
        }

        TextView tester1=(TextView)findViewById(R.id.testerTextView2);
        tester1.setText(location.getWeather().getTemperature());
        TextView tester2=(TextView)findViewById(R.id.testerTextView3);
        tester2.setText(list.get(2).getName());
        TextView tester3=(TextView)findViewById(R.id.testerTextView4);
        tester3.setText(list.get(3).getName());
        TextView tester4=(TextView)findViewById(R.id.testerTextView5);
        tester4.setText(list.get(4).getName());
        for(Location l: list)
            db.deleteLocation(l);
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_result, menu);
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
    public String getUserInput() {
        return null;
    }
    public void searchEntry(String entry) {

    }
}
