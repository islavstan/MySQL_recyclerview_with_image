package com.example.islav.androidmysqldatabase08recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by islav on 11.09.2016.
 */
public class DetailActivity extends AppCompatActivity {
    TextView nameTxt,teamTxt,positionTxt;
    ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
         nameTxt=(TextView)findViewById(R.id.nameTXTdetail);
        teamTxt=(TextView)findViewById(R.id.teamTXTdetail);
        positionTxt=(TextView)findViewById(R.id.positionTXTdetail);
        image =(ImageView)findViewById(R.id.imageDetail) ;
        Intent i =this.getIntent();
        String name = i.getExtras().getString("NAME_KEY");
        String team = i.getExtras().getString("TEAM_KEY");
        String position = i.getExtras().getString("POSITION_KEY");
        String imageurl = i.getExtras().getString("IMAGE_KEY");
       nameTxt.setText(name);
        teamTxt.setText(team);
        positionTxt.setText(position);
        PicassoClient.downloadImage(this,imageurl,image);

    }
}
