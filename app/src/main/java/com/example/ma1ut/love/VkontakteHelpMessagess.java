package com.example.ma1ut.love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;


public class VkontakteHelpMessagess extends AppCompatActivity {

    private String[] scope = new String[]{VKScope.MESSAGES, VKScope.FRIENDS, VKScope.WALL};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vkontakte_help_messages);
        VKSdk.login(this,scope);
        listView = (ListView)findViewById(R.id.listView);
        getVkRequest();
    }

    public void getVkRequest(){
        VKRequest request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "first_name,last_name"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VKList vkList = (VKList)response.parsedModel;

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(VkontakteHelpMessagess.this, android.R.layout.simple_expandable_list_item_1, vkList);
                listView.setAdapter(arrayAdapter);
            }
        });
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



}
