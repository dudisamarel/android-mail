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

    static List<Mail> mails;
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

        mails = generateMails();
        adapter = new MailsAdapter(mails, (SelectionListener) getActivity());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    private List<Mail> generateMails() {
        List<Mail> mails = new ArrayList<>();

        mails.add(new Mail("Israel Israeli", R.drawable.ic_launcher_background, "Regarding your money", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "1m"));
        mails.add(new Mail("Dina Danieli", R.drawable.ic_launcher_background, "Re: Yesterday", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "3h"));
        mails.add(new Mail("Yoni Yonieli", R.drawable.ic_launcher_background, "Hello", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "2d"));
        mails.add(new Mail("Moshe Moshieli", R.drawable.ic_launcher_background, "Vacation in Thailand", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "1.1.2000"));
        mails.add(new Mail("Udi Haudieli", R.drawable.ic_launcher_background, "Paycheck", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "9.9.1999"));
        mails.add(new Mail("Yossi Yossieli", R.drawable.ic_launcher_background, "Bills", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "6.6.1996"));

        return mails;
    }

    public static void setMailReply(Mail mail, int position) {
        mails.get(position).insertReplys(mail);
    }
}
