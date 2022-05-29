package com.example.android_mail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MailListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    List<Mail> mails;
    Fragment mailDetails;
    MailsAdapter adapter;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((SelectionListener) getActivity()).onItemSeleceted(mails.get(position), position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ((SelectionListener) getActivity()).onItemSeleceted(mails.get(position),position);
    }

    public interface SelectionListener{
        void onItemSeleceted(Mail mail, int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.mail_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mails = MailListStatic.getMailList();
        adapter = new MailsAdapter(mails, (SelectionListener) getActivity());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


//    private List<Mail> generateMails() {
//
//        return MailListStatic.getMailList();
//    }

//    public void setMailReply(Mail mail, int position) {
//        mails.get(position).insertReplys(mail);
//    }
}
