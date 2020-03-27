package com.example.hradvance.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.hradvance.R;

import java.util.ArrayList;

public class DialogValidation extends Dialog {
    Context context;



    public DialogValidation(Context context, ArrayList<String> messages) {
        super(context, R.style.MaterialDialogSheet1);
        try {
            this.context = context;
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_box_validation);
            this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.setCanceledOnTouchOutside(false);
            // this.getWindow().setType(WindowManager.LayoutParams.FIRST_SUB_WINDOW);
            this.getWindow().setLayout(ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);
            TextView tvTitle = (TextView) findViewById(R.id.tv_title);
            tvTitle.setText(context.getResources().getString(R.string.validation_title));
            TextView tvSubTitle = (TextView) findViewById(R.id.tv_sub_title);
            tvSubTitle.setText(context.getResources().getString(R.string.validation_sub_title));
            LinearLayout llValidation = (LinearLayout) findViewById(R.id.ll_validation);
            if (messages != null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                for (int i = 0; i < messages.size(); i++) {
                    View view = inflater.inflate(R.layout.validation_view, llValidation, false);
                    TextView tvName = (TextView) view.findViewById(R.id.tv_name);
                    tvName.setText(messages.get(i));
                    llValidation.addView(view);
                }
            }
            TextView ok = (TextView) findViewById(R.id.tv_ok);
            ok.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dismiss();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
