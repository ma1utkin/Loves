package com.example.ma1ut.love;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vk.sdk.util.VKUtil;

import java.util.Arrays;

public class MainApp extends AppCompatActivity {


    Button btnOk;
    AlertDialog.Builder ad;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        //Вызываем диалог с принятием правил
        alertDia();
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));

        btnOk = (Button)findViewById(R.id.btnOkMainApp);

    }

    /**
     * Метод вызываеться при нажатии на кнопку меню
     * @param view
     */
    public void btnOkMainAppClick(View view){
        Intent intent = new Intent(this, ZayaInfo.class);
        startActivity(intent);
    }

    /**
     * Диалоговое окно
     */
    public void alertDia(){
        context = MainApp.this;
        String title = "Внимание: ";
        String message = "Приложение находиться в тестируемой версии, возможно проблемы с визуализацией Элементов экранов";
        String button1String = "Ок, понятно";

        ad = new AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle);
        ad.setTitle(title);
        ad.setMessage(message);
        ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String info = "Спасибо за понимание, а теперь воспользуйтесь нашими услугами";
                Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();
            }
        });
        ad.show();
    }



}
