package boundary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.android.cz2006androidproject.R;

import java.util.ArrayList;
import java.util.List;

import control.CustomListAdapter;
import entity.PopularPlace;
import entity.SQLiteHelper;


public class PlacesListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list_view);

        Bundle extras = getIntent().getExtras();
        String category = extras.getString("parse this");
        List<String> placesList = new ArrayList<String>();
        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List<PopularPlace> list = db.getPopularPlaces();
        for(int i = 0;i<list.size();++i)
            if(list.get(i).getCategory().equals(category))
                placesList.add(list.get(i).getName());
        String[] places = new String[placesList.size()];
        places = placesList.toArray(places);
        int logo[]={R.mipmap.sunny,R.mipmap.rainy};//R.mipmap.cloudy,R.mipmap.sunny,R.mipmap.rainy};
        ListAdapter theAdapter = new CustomListAdapter(this, places,logo);
        final ListView theListView = (ListView) findViewById(R.id.placesListView);
        theListView.setAdapter(theAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_places_list_view, menu);
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
    public void buttonClicked(View view)
    {
        Button btn = (Button) view.findViewById(R.id.button1);
        SQLiteHelper db = new SQLiteHelper(this);
        db.getReadableDatabase();
        List<PopularPlace> list = db.getPopularPlaces();

        String placeName = (String)btn.getText();
        for(int i = 0;i<list.size();++i) {
            if(placeName.equals(list.get(i).getName()))
                btn.setText(String.valueOf(list.get(i).getLatitude()));
        }

    }


}
