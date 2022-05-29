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
            Mail newMail = new Mail(etFrom.getText().toString(),R.drawable.ic_launcher_background,etSubject.getText().toString(),etContent.getText().toString(),currentDate);
            MailListFragment.insertMail(newMail);
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        });

    }


}
