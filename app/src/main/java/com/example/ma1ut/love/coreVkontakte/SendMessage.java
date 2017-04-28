package com.example.ma1ut.love.coreVkontakte;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ma1ut.love.R;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import java.util.ArrayList;

public class SendMessage extends AppCompatActivity {

    EditText editText;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        editText = (EditText)findViewById(R.id.edText);
        btnOk = (Button)findViewById(R.id.btnClickMess);



    }

    public void send(View v){
        String message = editText.getText().toString();
        VKRequest request = new VKRequest("messages.send", VKParameters.from("user_id",268975709,"message", message));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                Toast.makeText(getApplicationContext(),"Отправлено", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
                Toast.makeText(getApplicationContext(),"Ошибка", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
