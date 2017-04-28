package com.example.ma1ut.love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ma1ut.love.coreVkontakte.SendMessage;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;


public class VkontakteHelpMessagess extends AppCompatActivity {

    private String[] scope = new String[]{VKScope.MESSAGES};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vkontakte_help_messages);
        VKSdk.login(this,scope);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast toast = Toast.makeText(getApplicationContext(), "Вы успешно вошли", Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void onError(VKError error) {
                finish();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onClickMess(View v){
        Intent intent = new Intent(this, SendMessage.class);
        startActivity(intent);
    }


}
