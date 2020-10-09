package cn.edu.szpt.soccerapp;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by User on 2018/6/25.
 */

public class StrGetTask extends AsyncTask<String,Void,String> {
    private TeamAdapter adapter;
    private List<TeamBean> list;

    public StrGetTask(TeamAdapter adapter, List<TeamBean> list) {
        this.adapter = adapter;
        this.list = list;
    }

    @Override

    protected String doInBackground(String... params) {
        String str=null;
        try {
            HttpURLConnection con= (HttpURLConnection) new URL(params[0]).openConnection();
            int code=con.getResponseCode();
            if(code==HttpURLConnection.HTTP_OK){
                InputStream is=con.getInputStream();
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                int n=0;
                byte[] buf=new byte[1024];

                while((n=is.read(buf))!=-1){
                    baos.write(buf,0,n);
                }
                str=baos.toString("UTF-8");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    protected void onPostExecute(String s) {
        if (s!=null){
            List<TeamBean> gsonList= new Gson().fromJson(s,new TypeToken<List<TeamBean>>(){}.getType());
            list.clear();
            list.addAll(gsonList);
            adapter.notifyDataSetChanged();
        }
    }

}
