package com.example.ma1ut.love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vk.sdk.util.VKUtil;

import java.util.Arrays;

public class MainApp extends AppCompatActivity {


    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));

        btnOk = (Button)findViewById(R.id.btnOkMainApp);

    }

    public void btnOkMainAppClick(View view){
        Intent intent = new Intent(this, ZayaInfo.class);
        startActivity(intent);
    }

}
