package com.example.ma1ut.love;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessagesActivity extends AppCompatActivity {
    Button btnMess;
    final String number = "89232309993";
    EditText sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        btnMess = (Button)findViewById(R.id.btnMess);
        sms = (EditText)findViewById(R.id.sms);
    }

    public void btnOkMess(View v){
        String smska = "smsto:" + number;
        String messages = sms.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(smska));
        intent.putExtra("sms_body", messages);
        startActivity(intent);
    }
}
