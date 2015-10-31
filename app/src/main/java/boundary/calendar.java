package boundary;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cz2006androidproject.R;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * This class is used to show calendar view.
 */
public class Calendar extends AppCompatActivity {

    CalendarView cal;
    private String[] dateWithPlan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        cal = (CalendarView) findViewById(R.id.calendar);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();
                int[] date = {year, month, dayOfMonth};
                if(date[2] == 30) {
                    Intent intent = new Intent(Calendar.this, ScheduleTabSwitch.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(Calendar.this, TravelPlanner.class);
                    intent.putExtra("parse this", date);
                    startActivity(intent);
                }
            }

            /*
            Intent i = new Intent(MainActivity.this, ViewDetails.class);
        Place pSample = new Place("Scenery", "Tourist Attractions", new Weather(), "Beautiful Scenery", "landscape_540115_1920");
        String[] pSampleArray = new String[10];
        for(int j=0;j<5;++j) {
            pSampleArray[j] = new String();
            pSampleArray[j] = (String)pSample.getDetails().get(j).toString();
        }
        i.putExtra("parse this", pSampleArray);
        startActivity(i);
             */

        });
    }

    //Move to HomePage
    public void homePageClicked(View view) {
        Intent intent = new Intent(Calendar.this, MainActivity.class);
        ActivityCompat.finishAffinity(this);
        startActivity(intent);
    }

    //Move to SearchPage
    public void searchPageClicked(View view) {
        Intent intent = new Intent(Calendar.this, SearchView.class);
        startActivity(intent);
    }



    /**
     * update the status of the date to indicate whether there is an existing plan or not on that
     * date.
     * @param date
     */
    public void updateCalendar(String date) {

    }
}
