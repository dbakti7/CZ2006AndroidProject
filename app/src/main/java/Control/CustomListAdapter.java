package control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.cz2006androidproject.R;


/**
 * Created by Windows7 on 10/20/2015.
 * this class is used to display several entries in the form of list
 */
public class CustomListAdapter extends ArrayAdapter<String> {
    int[] logos={};

    /**
     * class constructor
     * @param context required context from caller function
     * @param values places' name
     * @param logos places' picture or photo
     */
    public CustomListAdapter(Context context, String[] values,int[] logos) {
        super(context, R.layout.list_row_detail,values);
        this.logos=logos;
    }

    /**
     * for each entry, display in the form of list
     * @param position index
     * @param convertView view
     * @param parent parent view
     * @return view to be displayed
     */
    public View getView(int position, View convertView,ViewGroup parent){
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.list_row_detail, parent, false);
        String places = getItem(position);
        Button theButton = (Button) theView.findViewById(R.id.button1);
        theButton.setText(places);
        ImageView theImageView =(ImageView) theView.findViewById(R.id.imageView1);
        theImageView.setImageResource(logos[position]);
        return theView;
    }

}
