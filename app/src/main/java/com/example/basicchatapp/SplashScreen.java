package com.example.basicchatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //getting the shared preferences
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);
        //getting the user id and password
        String uid = sh.getString("uid", "");
        String password = sh.getString("password", "");
        //checking if there are any passwords and id stored in the shared preference
        if(uid.equals("") && password.equals("")) {
            //if no launching the Login activity
            Intent intent = new Intent(SplashScreen.this, Login.class);
            startActivity(intent);
        }
        else {
            //if yes launching the MainActivity
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
        }
    }
}