package com.app.jieshu.mvp.register.model;


import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.util.MyCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RegisterModel {
    /**
     * 注册
     *
     * @param user
     * @param pswd
     * @param sex
     * @param name
     * @param callBack
     */
    public void register(final String user, final String pswd, String sex, String name, final BaseCallBack<JSONObject> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("pswd", pswd);
        map.put("user", user);
        map.put("sex", sex);
        map.put("name", name);
        map.put("icon", "");
        OkGo.<JSONObject>post(Ip.USER + "register").params(map).execute(new MyCallBack() {
            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
                callBack.success(response.body());
            }

            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
                callBack.fail();
            }
        });
    }
}
