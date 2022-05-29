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

import java.util.Calendar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    RecyclerView replyLayout;

    MailListFragment mailListFragment;

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
        replyLayout = view.findViewById(R.id.replies);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        replyLayout.setLayoutManager(linearLayoutManager);
        replyLayout.setAdapter(new ReplayAdapter(this.getActivity()));
        replyLayout.setVisibility(view.VISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    public void setDetails(Mail mail, int positionNumber) {
        tvTitle.setText(mail.getSubject());
        tvContent.setText(mail.getContent());
        tvName.setText(mail.getName());
        tvDate.setText(mail.getDate());
        imgAvatar.setImageResource(mail.getAvatar());
        ((ReplayAdapter) replyLayout.getAdapter()).dataset.addAll(MailListStatic.getMailList().get(positionNumber).getReplys());
        replyLayout.getAdapter().notifyDataSetChanged();


        btnReply.setOnClickListener(view -> {
            if (String.valueOf(editText.getText()).length() != 0) {
                MailListStatic.getMailList().get(positionNumber).insertReplys(String.valueOf(editText.getText()));

                replyLayout.getAdapter().notifyDataSetChanged();
            }
        });


        if (!getView().isShown())
            getView().setVisibility(View.VISIBLE);
    }
}
