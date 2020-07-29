package com.app.jieshu.mvp.login.view;



public interface LoginView {

    /**
     * 显示进度
     */
    void  showLoading();

    /**
     * 隐藏进度
     */
    void hideLoading();


    void gotoMain();

}
