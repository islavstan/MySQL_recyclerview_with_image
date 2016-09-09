package com.example.islav.androidmysqldatabase08recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<Spacecraft>spacecrafts;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Spacecraft spacecraft =spacecrafts.get(position);
        holder.nameTxt.setText(spacecraft.getName());
       PicassoClient.downloadImage(c,spacecraft.getImageUrl(),holder.img);

    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}
