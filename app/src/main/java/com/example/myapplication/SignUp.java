package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class SignUp extends AppCompatActivity {
EditText signname, signheight, signweight, signage, signpw;
TextView signlog;
Spinner typespinner, genderspinner;
Button signregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signname= findViewById(R.id.signname);
        signheight= findViewById(R.id.signheight);
        signweight= findViewById(R.id.signweight);
        signage= findViewById(R.id.signage);
        signpw= findViewById(R.id.signpw);
        signlog= findViewById(R.id.signlog);
        typespinner= findViewById(R.id.typespinner);
        genderspinner= findViewById(R.id.genderspinner);
        signregister= findViewById(R.id.signregister);

        signlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(), LogIn.class);
                startActivity(i);
                finish();
            }
        });
        signregister.setOnClickListener(v -> {
            String name = signname.getText().toString();
            String height = signheight.getText().toString();
            String weight = signweight.getText().toString();
            String age = signage.getText().toString();
            String pw = signpw.getText().toString();
            String type = typespinner.getSelectedItem().toString();
            String gender = genderspinner.getSelectedItem().toString();

            if (name.equals("") || pw.equals("") || height.equals("") || weight.equals("") || age.equals("")) {

                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                String url = "http://localhost/CENG495/addplayer.php?p_name=" + name + "&typeOfWorkout=" + type +
                        "&age=" + age + "&height=" + height + "&weight=" + weight + "&gender=" + gender + "&p_password=" + pw;

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest(Request.Method.GET, url, response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(), error -> {
                    Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
                );
                queue.add(request);
            }
        });
    }}
