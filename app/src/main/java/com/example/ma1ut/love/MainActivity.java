package com.example.ma1ut.love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToZayaInfo(View view){
        Intent intent = new Intent(this, ZayaInfo.class);
        startActivity(intent);
    }
}
