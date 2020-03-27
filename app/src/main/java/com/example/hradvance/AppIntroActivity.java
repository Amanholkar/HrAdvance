package com.example.hradvance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hradvance.adapter.SliderAdapter;
import com.rd.PageIndicatorView;

public class AppIntroActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
   private ViewPager mSlideViewPager;
   private SliderAdapter sliderAdapter;
   private PageIndicatorView pageIndicatorView;
   private Button GetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_intro);

        mSlideViewPager= findViewById(R.id.slideViewPager);
       GetStarted=findViewById(R.id.getstartedbutton);
        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        pageIndicatorView =findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(3);
        mSlideViewPager.addOnPageChangeListener(this);

        GetStarted.setOnClickListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
       pageIndicatorView.setSelection(position);


        if (position == 2){

            GetStarted.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

        SharedPreferences sharedPreferences = getSharedPreferences( "com.example.hradvance", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int oneTimeStart=2;
        editor.putInt("message", oneTimeStart);
        editor.apply();
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //This is use for //delete the splashscrren from the stack
        startActivity(i);
    }
}
