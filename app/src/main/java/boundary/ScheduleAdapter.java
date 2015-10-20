package boundary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.cz2006androidproject.R;

/**
 * Created by Windows7 on 10/20/2015.
 */


class ScheduleAdapter extends ArrayAdapter<String> {
    int[] logos={};
    public ScheduleAdapter(Context context, String[] values,int[] logos) {
        super(context, R.layout.activity_view_schedule,values);
        this.logos=logos;
    }
    public View getView(int position, View convertView,ViewGroup parent){

        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.activity_view_schedule, parent, false);
        String places = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);

        theTextView.setText(places);

        ImageView theImageView =(ImageView) theView.findViewById(R.id.imageView1);
        theImageView.setImageResource(logos[position]);
        return theView;
    }
}