package com.wordpress.bytedebugger.viewpagertransforms;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by neo on 3/20/15.
 */
public class SlideFragment extends Fragment {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.slide_page, container, false);

        int position = getArguments().getInt(EXTRA_POSITION);
        TextView txt = (TextView)rootView.findViewById(R.id.textView);
        txt.setText("This is slide " + position); //edit the view text


        //set a random color to the background
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        rootView.setBackgroundColor(color); //set a random color to the background

        return rootView; //return the slide view
    }
}