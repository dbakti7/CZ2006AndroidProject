package boundary;

/**
 * Created by dbakti7 on 10/11/2015.
 * This class is used to show search page. User can select from given categories or enter a search
 * query.
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.cz2006androidproject.R;

import entity.Place;

public class SearchView extends Activity {
    private String searchEntry = new String();
    private String[] category = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

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

    //Move to CalendarPage
    public void calendarPageClicked(View view) {
        Intent intent = new Intent(SearchView.this, Calendar.class);
        startActivity(intent);
    }

    //Move to HomePage
    public void homePageClicked(View view) {
        Intent intent = new Intent(SearchView.this, MainActivity.class);
        ActivityCompat.finishAffinity(this);
        startActivity(intent);
    }
    String getUserInput(){
        return null;
    }

    public void touristAttractionsClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Tourist Attractions");
        startActivity(intent);
    }
    public void hotelsClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Hotels");
        startActivity(intent);
    }
    public void foodCentresClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Food Centres");
        startActivity(intent);
    }
    public void parksClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Parks");
        startActivity(intent);
    }
    public void museumClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Museums");
        startActivity(intent);
    }
    public void publicLibrariesClicked(View view) {
        Intent intent = new Intent(SearchView.this, PlacesListView.class);
        intent.putExtra("parse this", "Public Libraries");
        startActivity(intent);
    }

    public void searchEntry(String entry) {

    }
}
