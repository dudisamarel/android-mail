package com.example.android_mail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MailListFragment.SelectionListener {

    DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);

        Button btCreateMail = findViewById(R.id.new_mail);

        btCreateMail.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, CreateMailActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemSeleceted(Mail mail) {

        if (detailsFragment == null){
            Intent intent = new Intent();
            intent.setClass(this, DetailsActivity.class);
            intent.putExtra("position", mail);
            startActivity(intent);
        }
        else {
            detailsFragment.setDetails(mail);
        }

    }
}
