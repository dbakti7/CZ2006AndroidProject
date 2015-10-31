package Boundary;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.android.cz2006androidproject.R;

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
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();
            }
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
