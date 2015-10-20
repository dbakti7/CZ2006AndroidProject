package com.example.android.cz2006androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Windows7 on 10/20/2015.
 */
public class CustomListAdapter extends ArrayAdapter<String> {
    int[] logos={};
    public CustomListAdapter(Context context, String[] values,int[] logos) {
        super(context, R.layout.list_row_detail,values);
        this.logos=logos;
    }
    public View getView(int position, View convertView,ViewGroup parent){

        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.list_row_detail, parent, false);
        String places = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);

        theTextView.setText(places);

        ImageView theImageView =(ImageView) theView.findViewById(R.id.imageView1);
        theImageView.setImageResource(logos[position]);
        return theView;
    }
}
