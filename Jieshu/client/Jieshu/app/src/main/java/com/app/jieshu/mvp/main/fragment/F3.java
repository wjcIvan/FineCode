package com.app.jieshu.mvp.main.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.jieshu.R;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.bean.User;
import com.app.jieshu.mvp.feedback.FeedBackActivity;
import com.app.jieshu.mvp.login.LoginActivity;
import com.app.jieshu.mvp.user_msg.ChangePasswordActivity;
import com.app.jieshu.util.MyCallBack;
import com.app.jieshu.util.S;
import com.app.jieshu.util.T;
import com.app.jieshu.view.CircleImageView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;

/**
 * 我的 个人中心界面
 *
 * @author Administrator
 */
public class F3 extends Fragment implements OnClickListener {
    View view;
    User user;
    TextView tv_user;
    TextView tv_sex;
    TextView tv_name;

    TextView tv_zx, tvXY;

    RelativeLayout rl_sex;
    RelativeLayout rl_name, rl_user;

    RelativeLayout rl_pswd;
    boolean bool = false;
    AlertDialog.Builder mMaterialDialog;
    EditText contentView;
    int isex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f3, container, false);
        tv_user = (TextView) view.findViewById(R.id.regster_editText_user);
        tv_sex = (TextView) view.findViewById(R.id.regster_editText_sex);
        tv_name = (TextView) view.findViewById(R.id.regster_editText_name);
        tvXY = (TextView) view.findViewById(R.id.tvXY);

        rl_sex = (RelativeLayout) view.findViewById(R.id.rl_sex);
        rl_user = (RelativeLayout) view.findViewById(R.id.rl_user);
        rl_name = (RelativeLayout) view.findViewById(R.id.rl_name);

        rl_pswd = (RelativeLayout) view.findViewById(R.id.rl_pswd);

        tv_zx = (TextView) view.findViewById(R.id.tv_zx);
        tv_zx.setOnClickListener(this);
        rl_sex.setOnClickListener(this);
        rl_name.setOnClickListener(this);
        view.findViewById(R.id.rl_fk).setOnClickListener(this);

        rl_pswd.setOnClickListener(this);
        rl_pswd.setOnClickListener(this);


        user = S.getU();
        String u = user.getUser();
        String name = user.getName();
        String sex = user.getSex();

        tv_user.setText(u);
        tv_sex.setText(sex);
        tv_name.setText(name);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        tvXY.setText(S.getU().getCredit() + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.rl_name:
                contentView = new EditText(getActivity());
                contentView.setGravity(Gravity.CENTER);

                mMaterialDialog = new AlertDialog.Builder(getActivity()).setTitle("修改名字").setView(contentView);
                mMaterialDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nickname = contentView.getText().toString();
                        if (nickname.length() > 10 || nickname.length() < 2) {
                            Toast.makeText(getActivity(), "名字的长度为2~10之间", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            user.setName(nickname);
                            tv_name.setText(nickname);
                            bool = true;
                            dialog.dismiss();
                            update();
                        }
                    }
                });
                mMaterialDialog.setNegativeButton("取消", null);
                mMaterialDialog.show();
                break;

            case R.id.rl_sex:
                mMaterialDialog = new AlertDialog.Builder(getActivity());
                mMaterialDialog.setTitle("修改性别");
                NumberPicker picker = new NumberPicker(getActivity());
                picker.setDisplayedValues(new String[]{"男", "女"});
                picker.setMinValue(0);
                picker.setMaxValue(1);
                if (user.getSex().equals("男")) {
                    picker.setValue(0);
                    isex = 0;
                } else {
                    picker.setValue(1);
                    isex = 1;
                }
                picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

                    @Override
                    public void onValueChange(NumberPicker arg0, int arg1, int arg2) {
                        isex = arg2;

                    }
                });
                mMaterialDialog.setView(picker);
                mMaterialDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isex == 0) {
                            user.setSex("男");
                            tv_sex.setText("男");
                            bool = true;

                            dialog.dismiss();
                        } else {
                            user.setSex("女");
                            tv_sex.setText("女");
                            bool = true;

                            dialog.dismiss();
                        }
                        update();

                    }
                });
                mMaterialDialog.setNegativeButton("取消", null);
                mMaterialDialog.show();
                break;

            case R.id.rl_fk:
                startActivity(new Intent(getActivity(), FeedBackActivity.class));
                break;
            case R.id.rl_pswd:
                startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
                break;

            case R.id.tv_zx:
                S.setLogin(false);
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;

        }

    }

    private void update() {

        OkGo.<JSONObject>post(Ip.USER + "update").params("json", new Gson().toJson(user)).execute(new MyCallBack() {

            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
                JSONObject object = response.body();
                if (object.optString("code").equals("success")) {
                    S.setU(user);
                }
                T.show(object.optString("msg"));
            }

            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
            }
        });
    }
}
