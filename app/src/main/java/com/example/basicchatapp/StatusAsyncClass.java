package com.example.basicchatapp;

import android.os.AsyncTask;

public class StatusAsyncClass extends AsyncTask<Void, Void, Void> {
    //creating variables
    String uid, status;
    UserStatus us;

    //creating the constructor of this class taking user id and status as parameters
    StatusAsyncClass(String uid, String status) {
        //assigning the value of parameters to local variables
        this.uid = uid;
        this.status = status;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        //creating object of UserStatus class
        us = new UserStatus();
        //setting user status in the server using SetStatus method of UserStatus class
        us.SetStatus(uid, status);
        return null;
    }
}