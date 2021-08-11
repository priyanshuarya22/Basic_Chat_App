package com.example.basicchatapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class LoginAsyncClass extends AsyncTask<Void, Void, Void> {
    //creating variables
    String uid, password;
    Login login;
    SaveData sd;
    ProgressDialog pd;

    //constructor of this class taking object of login class, user id and password as arguments
    LoginAsyncClass(Login login, String uid, String password) {
        //assigning the value of arguments to local variables
        this.login = login;
        this.uid = uid;
        this.password = password;
        //creating objects
        sd = new SaveData();
        pd = new ProgressDialog(login);
        //setting message on progress dialog
        pd.setMessage("Logging in...");
        //starting the progress dialog
        pd.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //getting the result from CheckUser method of SaveData class
        String result = sd.CheckUser(uid, password);
        //checking if the user exists
        if (result.equals("Passed")) {
            //creating object of UserDetails class
            UserDetails ud = new UserDetails();
            //getting user name from server using GetUserDetail method of UserDetail class
            String name = ud.GetUserDetail(uid);
            //getting the shared preferences
            SharedPreferences sharedPreferences = login.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            //creating editor for shared preferences
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            //putting userid, password and user name in shared preferences
            myEdit.putString("uid", uid);
            myEdit.putString("password", password);
            myEdit.putString("name", name);
            //applying the edits
            myEdit.apply();
            //creating a new intent for MainActivity
            Intent intent = new Intent(login, MainActivity.class);
            //starting the activity
            login.startActivity(intent);
        }
        else {
            //creating a toast to inform user in case of a error
            Toast.makeText(login, result, Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        //stopping the progress dialog
        pd.dismiss();
    }
}
