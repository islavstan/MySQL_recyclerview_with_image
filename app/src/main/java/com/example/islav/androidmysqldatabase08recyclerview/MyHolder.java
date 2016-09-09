package com.example.islav.androidmysqldatabase08recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MyHolder extends RecyclerView.ViewHolder {
        TextView nameTxt;
    ImageView img;
    public MyHolder(View itemView) {
        super(itemView);
        nameTxt =(TextView)itemView.findViewById(R.id.rvname);
        img=(ImageView)itemView.findViewById(R.id.rimage);
    }
}
