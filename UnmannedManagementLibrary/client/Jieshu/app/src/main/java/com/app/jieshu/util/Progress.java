package com.app.jieshu.util;

import android.app.ProgressDialog;
import android.content.Context;

public class Progress {

    ProgressDialog dialog;

    public Progress(Context context) {
        dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        dialog.setCancelable(false);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        // dialog.setIcon(R.drawable.ic_launcher);//设置提示的title的图标，默认是没有的，如果没有设置title的话只设置Icon是不会显示图标的
        dialog.setTitle("提示");
    }

    public void show(String msg) {
        if (dialog != null) {
            dialog.setMessage(msg);
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
