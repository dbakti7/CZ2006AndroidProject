package boundary;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import com.example.android.cz2006androidproject.R;

import entity.SQLiteHelper;

/**
 * This class is used to show calendar view.
 */
public class Calendar extends AppCompatActivity {

    CalendarView cal;
    private int[] date = new int[3];
    SQLiteHelper db = new SQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        cal = (CalendarView) findViewById(R.id.calendar);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date[0] = year;
                date[1] = month;
                date[2] = dayOfMonth;
                String dateString = String.valueOf(date[0]) + String.valueOf(date[1]) + String.valueOf(date[2]);
                db.getWritableDatabase();
                if(db.getPlan(dateString) != null) {
                    Intent intent = new Intent(Calendar.this, ScheduleTabSwitch.class);
                    intent.putExtra("locationList", db.getPlan(dateString));
                    intent.putExtra("date", date);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(Calendar.this, TravelPlanner.class);
                    intent.putExtra("date", date);
                    String[] str = new String[0];
                    intent.putExtra("locationList", str);
                    startActivity(intent);
                }
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
        intent.putExtra("date", date);
        startActivity(intent);
    }
}
