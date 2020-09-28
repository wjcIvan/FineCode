package com.app.jieshu.mvp.register;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.app.jieshu.R;
import com.app.jieshu.base.BaseActivity;
import com.app.jieshu.mvp.register.presenter.RegisterPresenter;
import com.app.jieshu.mvp.register.view.RegisterView;
import com.app.jieshu.util.T;

import org.json.JSONObject;


/**
 * 注册页面
 *
 * @author Administrator
 */
public class RegisterActivity extends BaseActivity<RegisterView, RegisterPresenter> implements RegisterView, OnClickListener, RadioGroup.OnCheckedChangeListener {
    EditText et_user;
    EditText et_pswd, et_pswd2;

    EditText et_name;
    TextView tv_regster;
    LinearLayout ll_back;
    RadioButton rbMan;
    RadioGroup rg;
    String sex = "男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regster);
        initView();

    }

    @Override
    protected void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        rbMan = (RadioButton) findViewById(R.id.rb_man);
        et_user = (EditText) findViewById(R.id.regster_editText_user);
        et_pswd = (EditText) findViewById(R.id.regster_editText_password);
        et_pswd2 = (EditText) findViewById(R.id.regster_editText_passwords);

        et_name = (EditText) findViewById(R.id.regster_editText_name);

        tv_regster = (TextView) findViewById(R.id.regster_text_xiayibu);
        ll_back = (LinearLayout) findViewById(R.id.regster_layout_back);
        tv_regster.setOnClickListener(this);
        ll_back.setOnClickListener(this);
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == rbMan.getId()) {
            sex = "男";
        } else {
            sex = "女";
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regster_layout_back:
                finish();
                break;
            case R.id.regster_text_xiayibu:
                String user = et_user.getText().toString();
                String pswd = et_pswd.getText().toString();
                String pswds = et_pswd2.getText().toString();
                String name = et_name.getText().toString();

                if (pswds.equals("") || user.equals("") || pswd.equals("") || name.equals("")) {
                    T.show("所填内容不能为空");
                    return;
                }

                if (name.length() > 10 || name.length() < 2) {
                    T.show("名字的长度为2~10之间");
                    return;
                }

                if (!pswds.equals(pswd)) {
                    T.show("两次密码输入不一致");
                    return;
                }

                if (pswds.length() < 6 || pswds.length() > 16) {
                    T.show("密码的长度为6~16位");
                    return;
                }
                mPresenter.register(user, pswd, sex, name);


                break;

        }
    }

    @Override
    public void registerSuccess(JSONObject object) {
        if (object.optString("code").equals("success")) {
            finish();
        }
        T.show(object.optString("msg"));
    }
}
