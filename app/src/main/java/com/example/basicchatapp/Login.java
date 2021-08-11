package com.example.basicchatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //creating variables
    EditText et1, et2;
    Button b1, b2;
    SaveData sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //creating objects
        et1 = findViewById(R.id.login_et1);
        et2 = findViewById(R.id.login_et2);
        b1 = findViewById(R.id.login_b1);
        b2 = findViewById(R.id.login_b2);
        sd = new SaveData();
        //setting onclick listener for login button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting user id and password from edit text
                String uid = et1.getText().toString();
                String password = et2.getText().toString();
                //creating object of LoginAsyncClass and passing the object of current activity, user id and password as parameter
                LoginAsyncClass lac = new LoginAsyncClass(Login.this, uid, password);
                //executing the async class to log the user in
                lac.execute();
            }
        });
        //setting the onclick listener for signup button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a new intent for signup activity
                Intent intent = new Intent(Login.this, Signup.class);
                //starting the activity
                startActivity(intent);
            }
        });
    }

}