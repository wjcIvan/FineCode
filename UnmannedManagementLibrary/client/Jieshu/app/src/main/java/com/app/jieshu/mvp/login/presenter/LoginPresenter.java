package com.app.jieshu.mvp.login.presenter;


import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.base.BasePresenter;
import com.app.jieshu.bean.User;
import com.app.jieshu.mvp.login.model.LoginModel;
import com.app.jieshu.mvp.login.view.LoginView;
import com.app.jieshu.util.S;






public class LoginPresenter extends BasePresenter<LoginView> {

    LoginModel loginModel = new LoginModel();

    /**
     * 登录
     *
     * @param user
     * @param pswd
     */
    public void login(String user, String pswd) {
        getView().showLoading();
        loginModel.Login(user, pswd, new BaseCallBack<User>() {
            @Override
            public void success(User user) {
                getView().hideLoading();
                S.setU(user);//缓存登录信息
                S.setLogin(true);//缓存登录状态
                getView().gotoMain();
            }

            @Override
            public void fail() {
                getView().hideLoading();
            }
        });

    }


}
