package com.app.jieshu.bean;

import java.io.Serializable;

/**
 * 用户类
 *
 * @author Administrator
 */
public class User implements Serializable {
    int uid; // 用户id
    String user; // 用户名
    String pswd; // 密码
    String name; // 名字
    String sex;// 性别
    String icon;//
    private int credit;


    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public User() {
        super();
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(int uid, String user, String pswd, String name, String sex, String icon) {
        super();
        this.uid = uid;
        this.user = user;
        this.pswd = pswd;
        this.name = name;
        this.sex = sex;
        this.icon = icon;
    }

}
