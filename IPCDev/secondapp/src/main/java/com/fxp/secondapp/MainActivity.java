package com.fxp.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBackService();
    }

    private void startBackService(){
        try {
            Intent serviceIntent = new Intent();
            serviceIntent.setPackage("com.fxp.secondapp");
            serviceIntent.setAction("com.fxp.secondapp.service.BackService");
            startService(serviceIntent);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
