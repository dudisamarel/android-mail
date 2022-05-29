package com.example.android_mail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReplayAdapter extends RecyclerView.Adapter<ReplayAdapter.myViewHolder> {
    public ArrayList<String> dataset;
    private LayoutInflater mInflater;

    public ReplayAdapter( Context context) {
        dataset = new ArrayList<String>();
//        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.reply_details, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bind(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView tvName;
        TextView tvContent;
        TextView tvDate;


        public myViewHolder(View view) {
            super(view);
            imgAvatar = view.findViewById(R.id.imgAvatar);
            tvName = view.findViewById(R.id.tvName);
            tvContent = view.findViewById(R.id.tvContent);
            tvDate = view.findViewById(R.id.tvDate);
        }

        public void bind (String reply) {

            tvContent.setText(reply);
        }
    }
}
