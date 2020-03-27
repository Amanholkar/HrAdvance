package com.example.hradvance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hradvance.Utils.Utilities;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private ArrayList<String> messages;

    private boolean isValid = true;
    Utilities utilities;
    private EditText loginUsername;
    private EditText loginPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        utilities = Utilities.getInstance(this);
        messages = new ArrayList<>();

    }

    public void ForgetMethod(View view) {
        startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
    }

    public void LoginMethod(View view) {
        ValidateEmail();

        if (!isValid) {

            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
            utilities.dialogValidation(this, messages);

           messages.clear();


        }else{
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //This is use for //delete the LoginScreen from the stack
            startActivity(i);
        }

    }

    private void ValidateEmail() {
        String emailInput = loginUsername.getText().toString().trim();
        String passInput  = loginPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){

              messages.add("worng Email");
              isValid=false;
        }else if (Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            isValid=true;
            if (messages.size()>0) {
                messages.remove(messages);
            }
        }
        if (passInput.length() < 6){
            messages.add("Password Wrong");
            isValid=false;
        }else if (passInput.length() >= 6){
            if (messages.size()>0) {
                messages.remove(messages);
            }

            isValid=true;
        }
    }
}
