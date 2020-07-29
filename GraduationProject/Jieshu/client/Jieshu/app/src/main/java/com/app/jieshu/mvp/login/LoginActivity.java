package com.app.jieshu.mvp.login;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.jieshu.R;
import com.app.jieshu.base.BaseActivity;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.bean.User;
import com.app.jieshu.mvp.login.presenter.LoginPresenter;
import com.app.jieshu.mvp.login.view.LoginView;
import com.app.jieshu.mvp.main.MainActivity;
import com.app.jieshu.mvp.register.RegisterActivity;
import com.app.jieshu.util.Progress;
import com.app.jieshu.util.S;
import com.app.jieshu.util.T;


public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView, View.OnClickListener {


    EditText et_user;
    EditText et_password;
    TextView tv_regster;
    TextView tv_login;
    Progress pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    protected void initView() {
        pg = new Progress(this);
        Ip.initIp();
        // 初始化控件
        et_user = (EditText) findViewById(R.id.edit_denglu_user);
        et_password = (EditText) findViewById(R.id.edit_denglu_pwd);
        tv_login = (TextView) findViewById(R.id.tv_denglu_btn);
        tv_regster = (TextView) findViewById(R.id.tv_denglu_zhuce);

        tv_login.setOnClickListener(this);
        tv_regster.setOnClickListener(this);
        findViewById(R.id.ivOption).setOnClickListener(this);

        if (S.isLogin()) {


            User user = S.getU();
            if (user == null) {
                return;
            }
            String str_user = user.getUser();
            String str_password = user.getPswd();
            mPresenter.login(str_user, str_password);
        }
    }


    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showLoading() {
        pg.show("正在登录");
    }

    @Override
    public void hideLoading() {
        pg.dismiss();
    }

    @Override
    public void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    /**
     * 监听各种按钮
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_denglu_btn:
                String str_user = et_user.getText().toString();
                String str_password = et_password.getText().toString();
                mPresenter.login(str_user, str_password);

                break;
            case R.id.tv_denglu_zhuce:// 监听注册按钮
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.ivOption:
                final EditText editText = new EditText(LoginActivity.this);
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                editText.setText(S.getIp());
                editText.setSelection(S.getIp().length());
                new AlertDialog.Builder(LoginActivity.this).setTitle("设置服务器地址").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ip = editText.getText().toString();
                        if (ip.equals("")) {
                            T.show("输入的内容不能为空");
                        } else {
                            S.setIp(ip);
                            Ip.initIp();
                        }
                    }
                }).setNegativeButton("取消", null).show();
                break;

        }

    }


    long newTime;

    /**
     * 监听返回键
     */
    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - newTime > 2000) {
            newTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }


}
