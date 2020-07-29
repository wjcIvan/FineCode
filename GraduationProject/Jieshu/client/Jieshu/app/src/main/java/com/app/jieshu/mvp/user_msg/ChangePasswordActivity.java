package com.app.jieshu.mvp.user_msg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.jieshu.R;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.bean.User;
import com.app.jieshu.util.MyCallBack;
import com.app.jieshu.util.S;
import com.app.jieshu.util.T;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;


/**
 * 修改密码界面
 *
 * @author Administrator
 */
public class ChangePasswordActivity extends AppCompatActivity {

    LinearLayout ll_back;
    EditText et_yuan_password;
    EditText et_new_password;
    EditText et_new_password_again;
    TextView tv_xg;
    String yuan_password;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        user = S.getU();
        yuan_password = user.getPswd();
        et_yuan_password = (EditText) findViewById(R.id.change_password_editText_yuan_password);
        et_new_password = (EditText) findViewById(R.id.change_password_editText_new_password);
        et_new_password_again = (EditText) findViewById(R.id.change_password_editText_new_password_again);
        ll_back = (LinearLayout) findViewById(R.id.layout_back);
        ll_back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
        tv_xg = (TextView) findViewById(R.id.tv_xg);
        tv_xg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final String new_password = et_new_password.getText().toString();// 获取输入框输入的内容
                String new_password_again = et_new_password_again.getText().toString();
                String yuan = et_yuan_password.getText().toString();
                if (!yuan_password.equals(yuan)) {// 各种判断
                    Toast.makeText(ChangePasswordActivity.this, "原密码输入不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (new_password.length() < 1 || new_password_again.length() < 1) {
                    Toast.makeText(ChangePasswordActivity.this, "新密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!new_password.equals(new_password_again)) {
                    Toast.makeText(ChangePasswordActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (new_password.length() < 6 || new_password.length() > 16) {
                    T.show("密码的长度为6~16位");
                    return;
                }
                user.setPswd(new_password);
                OkGo.<JSONObject>post(Ip.USER + "update").params("json", new Gson().toJson(user)).execute(new MyCallBack() {

                    @Override
                    public void onSuccess(Response<JSONObject> response) {
                        super.onSuccess(response);
                        JSONObject object = response.body();
                        if (object.optString("code").equals("success")) {

                            S.setU(user);
                            finish();
                        }
                        T.show(object.optString("msg"));

                    }

                    @Override
                    public void onError(Response<JSONObject> response) {
                        super.onError(response);
                    }
                });


            }
        });

    }

}
