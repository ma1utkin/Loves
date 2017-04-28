package com.example.ma1ut.love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ZayaInfo extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnMessages;
    ImageButton btnVk;
    ImageButton btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaya_info);

        btnMessages = (ImageButton)findViewById(R.id.btnMessages);
        btnVk = (ImageButton)findViewById(R.id.btnVk);
        btnCall = (ImageButton) findViewById(R.id.btnCall);

        btnMessages.setOnClickListener(this);
        btnVk.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnMessages:
                intent = new Intent(this, MessagesActivity.class);
                startActivity(intent);
                break;
            case R.id.btnVk:
                intent = new Intent(this, VkontakteHelpMessagess.class);
                startActivity(intent);
                break;

            case R.id.btnCall:
                break;

        }
    }

    public void cancel_Click(View v){
        finish();
    }
}
