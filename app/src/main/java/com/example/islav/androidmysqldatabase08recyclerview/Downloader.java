package com.example.islav.androidmysqldatabase08recyclerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by islav on 08.09.2016.
 */
public class Downloader extends AsyncTask<Void,Void,String> {
    Context c;
    String urlAddress;
    RecyclerView rv;
    ProgressDialog pd;

    public Downloader(Context c, String urlAddress, RecyclerView rv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Загрузка");
        pd.setMessage("Загрузка...Пожалуйста ожидайте");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        if(s==null){
            Toast.makeText(c,"Не успешно",Toast.LENGTH_SHORT).show();
        }else {
       new DataParser(c,s,rv).execute();;

        }
    }

    private String downloadData(){
        HttpURLConnection con =Connector.connect(urlAddress);
        if(con==null){
            return null;
        }
        try{
            InputStream is=new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData = new StringBuffer();
            while ((line=br.readLine())!=null){
                jsonData.append(line+"\n");
            }
            br.close();
            is.close();
            return jsonData.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
