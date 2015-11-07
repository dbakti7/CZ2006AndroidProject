package control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.cz2006androidproject.R;

/**
 * Created by asus on 20-Oct-15.
 */
public class TravelPlannerAdapter extends ArrayAdapter<String> {
    int[] imgplaces={};
    public TravelPlannerAdapter(Context context, String[] values,int[] imgplaces) {
        super(context, R.layout.activity_view_schedule,values);
        this.imgplaces=imgplaces;
    }

    public View getView(int position, View convertView,ViewGroup parent){

        LayoutInflater tpInflater = LayoutInflater.from(getContext());
        View tpView = tpInflater.inflate(R.layout.travelplanner_adapter, parent, false);
        String places = getItem(position);
        TextView theTextView = (TextView) tpView.findViewById(R.id.tptv1);
        theTextView.setText(places);
        ImageView theImageView =(ImageView) tpView.findViewById(R.id.tpimg);
        theImageView.setImageResource(imgplaces[position]);
        return tpView;
    }
}
