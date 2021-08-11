package com.example.basicchatapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //creating variables
    LinearLayout ll1;
    CountDownTimer ct;
    SharedPreferences sh;
    String name, uid;
    CheckSeen cs;
    UserStatus us;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating objects
        ll1 = findViewById(R.id.a1_ll1);
        cs = new CheckSeen();
        us = new UserStatus();
        sh = getSharedPreferences("MySharedPref", MODE_APPEND);
        //getting the user id and password from shared preferences
        uid = sh.getString("uid", "");
        name = sh.getString("name", "");
        //calling getUsers method to display the names of other users
        getUsers();
        //stating a new countdown timer to refresh the activity after every 2 seconds
        ct = new CountDownTimer(10000,2000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                //recalling getUsers method
                getUsers();
            }

            @Override
            public void onFinish()
            {
                //restarting the countdown timer
                ct.start();
            }
        };
        //starting the countdown timer
        ct.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //creating the object of StatusAsyncClass and passing user id and 0 as parameters
        StatusAsyncClass sac = new StatusAsyncClass(uid, "0");
        //executing the class to set the status of user as offline on the server
        sac.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //creating the object of StatusAsyncClass and passing user id and 1 as parameters
        StatusAsyncClass sac = new StatusAsyncClass(uid, "1");
        //executing the class to set the status of user as online on the server
        sac.execute();
    }

    //method to display all the other users on the activity
    private void getUsers() {
        //getting the information of all the active users from the server using getActiveUsers method of UserStatus class
        String result = us.getActiveUsers();
        //if the result is an empty string return the function to avoid errors
        if(result.equals("")) {
            return;
        }
        //removing all previous views
        ll1.removeAllViews();
        //separating the users and putting them in an array
        String[] active = result.split(";");
        //looping through the users
        for(String user : active) {
            //again splitting the string to separate the name of user from their id
            String[] udetail = user.split(":");
            //checking if the user data from sever is equal to the current users
            if(udetail[0].equals(name)) {
                //if so skipping the further steps
                continue;
            }
            //creating a button
            Button b = new Button(MainActivity.this);
            //setting the text equal to the name of user
            b.setText(udetail[0]);
            //creating a array of seen
            String[] seens = cs.checkSeen(uid, udetail[1]).split(";");
            //creating a string color code to green
            String colorcode = "#00ff08";
            //checking if the array contains a 0
            if(Arrays.asList(seens).contains("0")) {
                //if so changing the color code to blue
                colorcode = "#0000ff";
            }
            //setting the background of button to color code
            b.setBackgroundColor(Color.parseColor(colorcode));
            //adding the button to the linear layout
            ll1.addView(b);
            //setting on click listener for this button
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //creating a new intent to Chat_Window class
                    Intent intent = new Intent(MainActivity.this, Chat_Window.class);
                    //putting receiver's id, name and status in intent
                    intent.putExtra("rid", udetail[1]);
                    intent.putExtra("rname", udetail[0]);
                    intent.putExtra("status", "online");
                    //starting the activity
                    startActivity(intent);
                }
            });
        }
        //getting the string containing information about the offline users
        String result1 = us.getOfflineUsers();
        //if the result is an empty string returning to avoid errors
        if(result1.equals("")) {
            return;
        }
        //splitting the string to get the info of individual offline user
        String[] offline = result1.split(";");
        //looping through the info
        for(String user1 : offline) {
            //extracting the name and id from the info
            String[] u1detail = user1.split(":");
            //creating a new button
            Button b = new Button(MainActivity.this);
            //setting text equals to the name of user on button
            b.setText(u1detail[0]);
            //getting the array of seen from server
            String[] seens = cs.checkSeen(uid, u1detail[1]).split(";");
            //setting color code to red
            String colorcode = "#ff0000";
            //checking if the array contains 0
            if(Arrays.asList(seens).contains("0")) {
                //if so setting the color code to blue
                colorcode = "#0000ff";
            }
            //changing the background color of the button
            b.setBackgroundColor(Color.parseColor(colorcode));
            //adding the button on the linear layout
            ll1.addView(b);
            //setting on click listener to the button
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //creating a new intent for Chat_Window class
                    Intent intent = new Intent(MainActivity.this, Chat_Window.class);
                    //putting the receiver's id, name and status in the intent
                    intent.putExtra("rid", u1detail[1]);
                    intent.putExtra("rname", u1detail[0]);
                    intent.putExtra("status", "offline");
                    //starting the activity
                    startActivity(intent);
                }
            });
        }
    }

}