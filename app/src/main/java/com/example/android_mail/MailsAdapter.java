package com.example.android_mail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_mail.Mail;

import java.util.List;

public class MailsAdapter extends BaseAdapter {

    List<Mail> mails;
    MailListFragment.SelectionListener listener;

    public MailsAdapter(List<Mail> mails, MailListFragment.SelectionListener listener){
        this.mails = mails;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return mails.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_list_item, parent, false);

            convertView.setTag(new ViewHolder(convertView));
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();

        Mail mail = mails.get(position);

        holder.imgAvatar.setImageResource(mail.getAvatar());
        holder.tvTitle.setText(mail.getName());
        holder.tvSubTitle.setText(mail.getSubject());
        holder.tvContent.setText(mail.getContent());
        holder.tvDate.setText(mail.getDate());

        return convertView;
    }

    class ViewHolder{

        ImageView imgAvatar;
        TextView tvTitle;
        TextView tvSubTitle;
        TextView tvContent;
        TextView tvDate;


        public ViewHolder(View view) {
            imgAvatar = view.findViewById(R.id.imgAvatar);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvSubTitle = view.findViewById(R.id.tvSubTitle);
            tvContent = view.findViewById(R.id.tvContent);
            tvDate = view.findViewById(R.id.tvDate);
        }
    }
}
