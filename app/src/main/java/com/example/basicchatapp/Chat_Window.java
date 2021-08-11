package com.example.basicchatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Chat_Window extends AppCompatActivity {
    //creating variables
    Intent intent;
    TextView tv1;
    LinearLayout ll1;
    EditText et1;
    Button b1;
    GetChat gc;
    SharedPreferences sh;
    String uid, rid, name;
    CountDownTimer ct;
    SendMessage sm;
    UserStatus us;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        //creating objects
        intent = getIntent();
        tv1 = findViewById(R.id.chatwin_tv1);
        ll1 = findViewById(R.id.chatwin_ll1);
        et1 = findViewById(R.id.chatwin_et1);
        b1 = findViewById(R.id.chatwin_b1);
        gc = new GetChat();
        us = new UserStatus();
        sh = getSharedPreferences("MySharedPref", MODE_APPEND);
        //getting user id and name from shared preferences
        uid = sh.getString("uid", "");
        name = sh.getString("name", "");
        //displaying the chats
        chatstart();
        //creating a new countdown timer
        ct = new CountDownTimer(6000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                //refreshing the chat after 100 millisecond
                chatstart();
            }

            @Override
            public void onFinish() {
                //restarting the countdown timer
                ct.start();
            }
        };
        //starting the countdown timer
        ct.start();
        //setting onclick listener for send button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting the message
                String message = name + ">>> " + et1.getText().toString();
                //creating object of send message class
                sm = new SendMessage();
                //sending message using sendMessage method
                sm.sendMessage(uid, rid, message);
                //removing text from edit text
                et1.setText("");
            }
        });
    }

    //method which sets the chat on chat window
    private void chatstart() {
        //remove all previous chats
        ll1.removeAllViews();
        //getting receiver's id from intent
        rid = intent.getStringExtra("rid");
        //getting receiver's name from intent
        String rname = intent.getStringExtra("rname");
        //getting receiver's status from intent
        String status = intent.getStringExtra("status");
        //setting receiver's name on text view
        tv1.setText(rname);
        //checking if receiver is online and thus setting the background of text
        if(status.equals("online")) {
            //setting background to green if receiver is online
            tv1.setBackgroundColor(Color.parseColor("#00ff08"));
        }
        else {
            //else setting background to red
            tv1.setBackgroundColor(Color.parseColor("#ff0000"));
        }
        //getting array of messages from server using GetMessage method of GetChat Class
        String result[] = gc.GetMessage(uid, rid).split(";");
        //starting the for loop to iterate through chats
        for(String lines : result) {
            //again splitting the lines to separate message from seen
            String line[] = lines.split(":");
            //creating a new textview
            TextView tv = new TextView(Chat_Window.this);
            //setting message as text
            tv.setText(line[0]);
            //adding the textview to linear layout
            ll1.addView(tv);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //creating an object of StatusAsyncClass and passing user id an 0 as parameters
        StatusAsyncClass sac = new StatusAsyncClass(uid, "0");
        //executing the Async class to set the user status as offline
        sac.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //creating an object of StatusAsyncClass and passing user id and 1 as parameter
        StatusAsyncClass sac = new StatusAsyncClass(uid, "1");
        //executing the Async class to set the user status as online
        sac.execute();
    }

}