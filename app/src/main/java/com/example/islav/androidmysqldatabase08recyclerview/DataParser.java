package com.example.islav.androidmysqldatabase08recyclerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DataParser extends AsyncTask<Void,Void,Boolean> {

Context c;
   String jsonData;
    RecyclerView rv;

ProgressDialog pd;
    ArrayList<Spacecraft>spacecrafts=new ArrayList<>();
    public DataParser(Context c, String jsonData, RecyclerView rv) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }



    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean parsed) {
        super.onPostExecute(parsed);
        pd.dismiss();
        if(parsed){
            //BIND DATA TO RECYCLERVIEW
            CustomAdapter adapter=new CustomAdapter(c,spacecrafts);
            rv.setAdapter(adapter);

        }else{
            Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();

        }
    }
    private Boolean parseData(){
        try{
            JSONArray ja = new JSONArray(jsonData);
          JSONObject jo;
            spacecrafts.clear();
            Spacecraft spacecraft;
            for(int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);
                int id = jo.getInt("id");
                String name =jo.getString("name");
                String team =jo.getString("team");
                String position =jo.getString("position");
                String imageUrl =jo.getString("image");

                spacecraft =new Spacecraft();
                spacecraft.setId(id);
                spacecraft.setName(name);
                spacecraft.setTeam(team);
                spacecraft.setPosition(position);
                spacecraft.setImageUrl(imageUrl);

                spacecrafts.add(spacecraft);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
