package com.example.ma1ut.love.coreVkontakte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ma1ut.love.R;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;

import java.util.List;

public class FriendsList extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        listView = (ListView)findViewById(R.id.listView);
        VKRequest request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "first_name,last_name"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VKList vkList = (VKList)response.parsedModel;

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FriendsList.this, android.R.layout.simple_expandable_list_item_1, vkList);
                listView.setAdapter(arrayAdapter);
            }
        });
    }
}
