package com.example.hradvance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

public class SplashScreenActivity extends AppCompatActivity {
   private Handler mHandler;

   private Runnable mRunnable;
   int oneTimeStart =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences getSharedPrefs = getSharedPreferences( "com.example.hradvance", MODE_PRIVATE);
        int value = getSharedPrefs.getInt("message",0);
        oneTimeStart=value;
        mRunnable = new Runnable() {
            @Override
            public void run() {
               if (oneTimeStart==0) {
                   Intent i = new Intent(getApplicationContext(), AppIntroActivity.class);
                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //This is use for //delete the splashscrren from the stack


                   startActivity(i);
               }else{
                   Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //This is use for //delete the splashscrren from the stack
                   startActivity(i);
               }
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable,2000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler!=null &&mRunnable != null)
            mHandler.removeCallbacks(mRunnable);
    }
}
