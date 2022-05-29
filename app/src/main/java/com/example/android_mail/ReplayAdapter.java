package com.example.android_mail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReplayAdapter extends RecyclerView.Adapter<ReplayAdapter.viewHolder> {
    public ArrayList<Mail> dataset;
    private LayoutInflater mInflater;

    public ReplayAdapter( Context context) {

        this.mInflater = LayoutInflater.from(context);;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.reply_details, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {


         public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
