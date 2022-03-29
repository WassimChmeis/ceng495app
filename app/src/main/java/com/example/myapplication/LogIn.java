package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
Button logbtn;
EditText logid, logpass;
TextView logsignup, admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logbtn= findViewById(R.id.logbtn);
        logid= findViewById(R.id.logid);
        logpass= findViewById(R.id.logpass);
        logsignup= findViewById(R.id.logsignup);
        admin= findViewById(R.id.admin);

        logsignup.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), SignUp.class);
            startActivity(i);
            finish();
        });

        logbtn.setOnClickListener(v -> {

        });
    }
}