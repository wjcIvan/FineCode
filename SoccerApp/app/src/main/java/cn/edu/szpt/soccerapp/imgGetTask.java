package cn.edu.szpt.soccerapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import android.support.v4.util.LruCache;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 2018/6/25.
 */

public class imgGetTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView img;
    private String country;
    private LruCache<String,Bitmap> cache;

    public imgGetTask(ImageView img, String country, LruCache<String, Bitmap> cache) {
        this.img = img;
        this.country = country;
        this.cache = cache;
    }

    @Override
    protected void onPreExecute() {
        img.setImageBitmap(null);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bmp=null;
        try {
            HttpURLConnection con= (HttpURLConnection) new URL(params[0] + params[1]).openConnection();
            int code=con.getResponseCode();
            if(code==HttpURLConnection.HTTP_OK){
                InputStream is=con.getInputStream();
                bmp= BitmapFactory.decodeStream(is);
                if(bmp!=null){
                    cache.put(params[1],bmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(bitmap!=null &&country.equals(img.getTag().toString())){
            img.setImageBitmap(bitmap);
        }
    }
}
