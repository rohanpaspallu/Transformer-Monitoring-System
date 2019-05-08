package com.example.rohanpaspallu.dummy_tms;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by Priyanka Wagh on 26-01-2017.
 */
public class Splash extends Activity {
    Intent i;




    //Permision code that will be checked in the method onRequestPermissionsResult
    private int STORAGE_PERMISSION_CODE = 23;


    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysplash);

        //  if(isReadStorageAllowed()){
        //If permission is already having then showing the toast
        //  Toast.makeText(Splashscreen.this,"You already have the permission", Toast.LENGTH_LONG).show();

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{




                    sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                    if (sharedpreferences.contains("email_id")) {

                      Intent  intent = new Intent(getApplicationContext(),Home_activity.class);

                        startActivity(intent);
                    }
                    else{
                        Intent intent1 = new Intent(getApplicationContext(),Login_activity.class);

                        startActivity(intent1);
                    }
                }
            }
        };
        timerThread.start();

        //Existing the method with return
        return;
    }

    //If the app has not the permission then asking for the permission
    //  requestStoragePermission();






    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }


}

