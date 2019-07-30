package com.example.infodotafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private int wkt=2000;

    //2000= 2 detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan pindah ke HomeActivity

                Intent home = new Intent(MainActivity.this, MenuActivity.class);

                startActivity(home);
                finish();
            }
        }, wkt);
    }
}