package boundary;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.cz2006androidproject.R;

import java.lang.*;

/**
 * This class is used to view details of a place.
 */
public class ViewDetails extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String name = extras.getString("name");
            String imageLink = extras.getString("image");
            String condition = extras.getString("condition");
            String temperature = extras.getString("temperature");
            String humidity = extras.getString("humidity");
            ImageView iv = (ImageView)findViewById(R.id.ivVIEWDETAILSimage);
            iv.setImageResource(getResources().getIdentifier(
                    imageLink, "mipmap", this.getPackageName()));
            TextView placeName=(TextView)findViewById(R.id.tvVIEWDETAILSname);
            placeName.setText(name);
            TextView conditionText=(TextView)findViewById(R.id.tvVIEWDETAILScondition);
            conditionText.setText("Weather Condition: " + condition);
            TextView temperatureText =(TextView)findViewById(R.id.tvVIEWDETAILStemperature);
            temperatureText.setText("Temperature: " + temperature);
            TextView humidityText =(TextView)findViewById(R.id.tvVIEWDETAILShumidity);
            humidityText.setText("Humidity: " + humidity);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_details, menu);
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
