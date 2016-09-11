package com.example.islav.androidmysqldatabase08recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTxt;
    ImageView img;
    ItemClickListener itemClickListener;
    public MyHolder(View itemView) {
        super(itemView);
        nameTxt =(TextView)itemView.findViewById(R.id.rvname);
        img=(ImageView)itemView.findViewById(R.id.rimage);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
 this.itemClickListener.onItemClick();
    }
    public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
}
