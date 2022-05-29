package com.example.android_mail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsFragment extends Fragment {

    TextView tvTitle;
    TextView tvContent;
    TextView tvName;
    ImageView imgAvatar;
    TextView tvDate;
    FloatingActionButton btn;
    ImageButton btnReply;
    EditText editText;

    public DetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mail_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tvTitle);
        tvContent = view.findViewById(R.id.tvContent);
        tvName = view.findViewById(R.id.tvName);
        tvDate = view.findViewById(R.id.tvDate);
        imgAvatar = view.findViewById(R.id.imgAvatar);
        btnReply = view.findViewById(R.id.btnReply);
        editText = view.findViewById(R.id.editText);

        view.setVisibility(View.INVISIBLE);
    }

    public void setDetails(Mail mail) {
        tvTitle.setText(mail.getSubject());
        tvContent.setText(mail.getContent());
        tvName.setText(mail.getName());
        tvDate.setText(mail.getDate());
        imgAvatar.setImageResource(mail.getAvatar());
        btnReply.setOnClickListener(view -> {
            if (String.valueOf(editText.getText()).length() != 0) {
                Log.i("reply", String.valueOf(editText.getText()));
            }
        });


        if (!getView().isShown())
            getView().setVisibility(View.VISIBLE);
    }
}
