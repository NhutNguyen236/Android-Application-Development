package com.example.exercise01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AfterLogin extends AppCompatActivity {

    private TextView userName, passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        userName = (TextView)findViewById(R.id.userName);
        passWord = (TextView)findViewById(R.id.passWord);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String username = bundle.getString("username");
            String pwd = bundle.getString("password");

            //Insert username and password in to the TextView with the correct order
            userName.setText(username);
            passWord.setText(pwd);
        }
    }
}