package com.example.basicchatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    //creating variables
    EditText et1, et2, et3, et4, et5, et6;
    Button b1;
    SaveData sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //creating objects
        et1 = findViewById(R.id.signup_et1);
        et2 = findViewById(R.id.signup_et2);
        et3 = findViewById(R.id.signup_et3);
        et4 = findViewById(R.id.signup_et4);
        et5 = findViewById(R.id.signup_et5);
        et6 = findViewById(R.id.signup_et6);
        b1 = findViewById(R.id.signup_b1);
        sd = new SaveData();
        //setting onclick listener for signup button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a array
                String[] data = new String[6];
                //inserting data in array
                data[0] = et1.getText().toString();
                data[1] = et2.getText().toString();
                data[2] = et3.getText().toString();
                data[3] = et4.getText().toString();
                data[4] = et5.getText().toString();
                data[5] = et6.getText().toString();
                //creating an object of SignupAsyncClass and passing object of this class and the array as parameters
                SignupAsyncClass sac = new SignupAsyncClass(Signup.this, data);
                //executing the Async class
                sac.execute();
            }
        });
    }
}