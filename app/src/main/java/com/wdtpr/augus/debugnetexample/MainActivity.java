package com.wdtpr.augus.debugnetexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wdtpr.augus.debugnetexample.view.bj.BjActivity;

public class MainActivity extends AppCompatActivity {

    // store 2 //customer 17 //pet 5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //camplay
//            startActivity(new Intent(this,CamplayDebugActivity.class));
        //Pet
//        startActivity(new Intent(this, PetDebugActivity.class));
        //permission
//        startActivity(new Intent(this, PermissionActivity.class));
        //fb
//        startActivity(new Intent(this, FaceBookDemoActivity.class));
        //progress
//                startActivity(new Intent(this, DialogActivity.class));
        //bj
        startActivity(new Intent(this, BjActivity.class));

    }


}
