package com.example.hradvance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hradvance.Utils.Utilities;

import java.util.ArrayList;

public class ForgotPasswordActivity extends AppCompatActivity {
    Utilities utilities;
    private ArrayList<String> message;
    private EditText forgotUserName;
    private Button submitForgot;
    private boolean isValid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        forgotUserName = findViewById(R.id.editText_forgot_username);
        submitForgot = findViewById(R.id.submit_forgotemail);
        utilities = Utilities.getInstance(this);
        message= new ArrayList<>();
    }

    public void backMethos(View view) {
      onBackPressed();
    }


    public void SubmitMethod(View view) {
        ValidateEmail();

        if (!isValid) {

            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
            utilities.dialogValidation(this, message);

            message.clear();
        }
    }
    private void ValidateEmail() {
        String emailInput = forgotUserName.getText().toString().trim();


        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){

            message.add("worng Email");
            isValid=false;
        }else if (Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            isValid=true;
            if (message.size()>0) {
                message.remove(message);
            }
        }

    }
}
