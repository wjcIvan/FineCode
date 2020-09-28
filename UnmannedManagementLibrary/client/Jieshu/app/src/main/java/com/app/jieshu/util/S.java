package com.app.jieshu.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.jieshu.bean.Ip;
import com.app.jieshu.bean.User;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/1/1.
 */
public class S {
    public static Context context;

    public static boolean isLogin() {
        SharedPreferences preferences = T.context.getSharedPreferences("isLogin", T.context.MODE_PRIVATE);
        return preferences.getBoolean("isLogin", false);

    }

    public static void setLogin(boolean isLogin) {
        SharedPreferences preferences = T.context.getSharedPreferences("isLogin", T.context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLogin", isLogin).commit();

    }

    public static void setU(User u) {
        SharedPreferences preferences = context.getSharedPreferences("user", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", new Gson().toJson(u)).commit();

    }

    public static User getU() {
        SharedPreferences preferences = context.getSharedPreferences("user", context.MODE_PRIVATE);
        return new Gson().fromJson(preferences.getString("user", ""), User.class);

    }

    public static String getIp() {
        SharedPreferences preferences = T.context.getSharedPreferences("ip", T.context.MODE_PRIVATE);
        return preferences.getString("ip", Ip.ip);

    }

    public static void setIp(String ip) {
        SharedPreferences preferences = T.context.getSharedPreferences("ip", T.context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ip", ip).commit();

    }
}
