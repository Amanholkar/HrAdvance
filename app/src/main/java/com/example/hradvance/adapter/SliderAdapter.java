package com.example.hradvance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hradvance.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Array

    public  int[] slide_images ={
            R.drawable.leaves,
            R.drawable.disciplinary,
            R.drawable.timesheet
    };

    public String[] slide_headings = {
            "Track leaves and apply\n" +
                    "      leaves on-the-go",
            "Disciplinaries \n",
            "Manage your work by\n" +
                    "    filling time-sheets"
    };

    public String[] slide_descs ={
            " You can check your leave balance and\n" +
                    "apply for leaves with you mobile device\n" +
                    "                          on-the-go",
            " Want to five asuggestion or feedback, \n" +
                    "   Or Do you smell aa rat? Send your \n" +
                    "valuable observation to management.",
            " Update your daily tasks and work details\n" +
                    "      on-the-go and keep tracks of your\n" +
                    "                              deadlines."
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView =view.findViewById(R.id.slide_image);
        TextView  slideHeaderView= view.findViewById(R.id.slide_header);
        TextView  slideDescption =view.findViewById(R.id.slide_descsption);

        slideImageView.setImageResource(slide_images[position]);
        slideHeaderView.setText(slide_headings[position]);
        slideDescption.setText(slide_descs[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
