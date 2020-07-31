package com.app.jieshu.mvp.register.presenter;


import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.base.BasePresenter;
import com.app.jieshu.mvp.register.model.RegisterModel;
import com.app.jieshu.mvp.register.view.RegisterView;
import com.app.jieshu.util.T;

import org.json.JSONObject;



public class RegisterPresenter extends BasePresenter<RegisterView> {

    RegisterModel rModel = new RegisterModel();

    /**
     * 注册
     *
     * @param user
     * @param pswd
     * @param sex
     * @param name
     */
    public void register(String user, String pswd, String sex, String name) {
        rModel.register(user, pswd, sex, name, new BaseCallBack<JSONObject>() {
            @Override
            public void success(JSONObject result) {
                getView().registerSuccess(result);
            }

            @Override
            public void fail() {
                T.show("连不上服务端......");
            }
        });

    }


}
