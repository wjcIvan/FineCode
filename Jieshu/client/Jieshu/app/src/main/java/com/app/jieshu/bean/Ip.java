package com.app.jieshu.bean;


import com.app.jieshu.util.S;

/**
 * Created by Administrator on 2019/3/1
 */
public class Ip {
    public static String ip = "106.15.199.111";
  //  public static String ip = "192.168.0.167";
    public static String USER = "http://" + S.getIp() + ":8080/JieshuService/user/";
    public static String ICON = "http://" + S.getIp() + ":8080/JieshuService/img/";
    public static String SHUJIA = "http://" + S.getIp() + ":8080/JieshuService/shujia/";
    public static String BOOK = "http://" + S.getIp() + ":8080/JieshuService/book/";
    public static String BORROW = "http://" + S.getIp() + ":8080/JieshuService/borrow/";


    public static String THEATRE = "http://" + S.getIp() + ":8080/JieshuService/theatre/";
    public static String SHOWPLACE = "http://" + S.getIp() + ":8080/JieshuService/showplace/";
    public static String CI = "http://" + S.getIp() + ":8080/JieshuService/ci/";
    public static String TICKET = "http://" + S.getIp() + ":8080/JieshuService/ticket/";
    public static String PING = "http://" + S.getIp() + ":8080/JieshuService/ping/";

    public static void initIp() {
        ip = S.getIp();
        USER = "http://" + S.getIp() + ":8080/JieshuService/user/";
        ICON = "http://" + S.getIp() + ":8080/JieshuService/img/";
        SHUJIA = "http://" + S.getIp() + ":8080/JieshuService/shujia/";
        BOOK = "http://" + S.getIp() + ":8080/JieshuService/book/";
        BORROW = "http://" + S.getIp() + ":8080/JieshuService/borrow/";

        THEATRE = "http://" + S.getIp() + ":8080/JieshuService/theatre/";
        SHOWPLACE = "http://" + S.getIp() + ":8080/JieshuService/showplace/";
        CI = "http://" + S.getIp() + ":8080/JieshuService/ci/";
        TICKET = "http://" + S.getIp() + ":8080/JieshuService/ticket/";
        PING = "http://" + S.getIp() + ":8080/JieshuService/ping/";
    }

}
