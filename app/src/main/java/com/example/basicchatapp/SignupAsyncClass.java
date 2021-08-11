package com.example.basicchatapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

@SuppressLint("StaticFieldLeak")
public class SignupAsyncClass extends AsyncTask<Void, Void, Void> {
    //creating variables
    Signup signup;
    String[] data;
    ProgressDialog pd;
    SaveData sd;
    String result;

    //creating a constructor which takes object of Signup class and array of string data
    SignupAsyncClass(Signup signup, String[] data) {
        //assigning the value of parameters to local variables
        this.signup = signup;
        this.data = data;
        //creating objects
        sd = new SaveData();
        pd = new ProgressDialog(signup);
        //setting message on the progress dialog
        pd.setMessage("Signing in...");
        //showing the progress dialog
        pd.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        result = sd.CreateUser(data);
        //getting shared preferences
        SharedPreferences sharedPreferences = signup.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        //creating editor for shared preferences
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        //putting userid, password and name in shared preferences
        myEdit.putString("uid", data[0]);
        myEdit.putString("password", data[5]);
        myEdit.putString("name", data[1]);
        //applying the edits
        myEdit.apply();
        //creating a new intent for MAinActivity
        Intent intent = new Intent(signup, MainActivity.class);
        //starting the activity
        signup.startActivity(intent);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        //stopping the progress dialog
        pd.dismiss();
        //making toast to inform user of the result
        Toast.makeText(signup, result, Toast.LENGTH_SHORT).show();
    }
}
