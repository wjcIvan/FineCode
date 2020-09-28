package com.app.jieshu.mvp.login.model;


import com.app.jieshu.bean.Ip;
import com.app.jieshu.bean.User;
import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.util.MyCallBack;
import com.app.jieshu.util.T;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;



public class LoginModel {
    /**
     * 登录
     *
     * @param user 用户名
     * @param pswd 密码
     * @return
     */
    public void Login(final String user, final String pswd, final BaseCallBack<User> callBack) {
        OkGo.<JSONObject>get(Ip.USER + "login").params("user", user).params("pswd", pswd).execute(new MyCallBack() {
            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
                JSONObject object = response.body();
                if (object.optString("code").equals("success")) {

                    //gson解析用户信息
                    User user = new Gson().fromJson(object.optString("data"), User.class);
                    callBack.success(user);
                }else{
                    callBack.fail();
                }
                T.show(object.optString("msg"));

            }

            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
                callBack.fail();
                T.show("登录失败！");
            }
        });

    }


}
