package com.example.android_mail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateMailActivity extends AppCompatActivity  {
EditText etTo,etFrom,etSubject,etContent;
Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mail);
        etTo = findViewById(R.id.et_to);
        etFrom = findViewById(R.id.et_from);
        etSubject = findViewById(R.id.et_subject);
        etContent = findViewById(R.id.et_content);
        btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(view -> {
            String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            int rnd = (int) Math.round(Math.random() *3),avatar;
            switch(rnd) {
                case 1:
                    avatar = R.mipmap.icon_1;
                    break;
                case 2:
                    avatar = R.mipmap.icon_2;
                    break;
                default:
                    avatar = R.mipmap.icon_3;
            }
            Mail newMail = new Mail(etFrom.getText().toString(),avatar,etSubject.getText().toString(),etContent.getText().toString(),currentDate);
            MailListFragment.insertMail(newMail);
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        });

    }


}
