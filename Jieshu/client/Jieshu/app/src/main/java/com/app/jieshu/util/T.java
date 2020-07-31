package com.app.jieshu.util;

import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class T {

    public static Context context;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void show(String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static String getTime() {
        return simpleDateFormat.format(System.currentTimeMillis());
    }

}
