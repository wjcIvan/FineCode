package com.app.jieshu.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);//绑定view
    }


    /**
     * 初始化
     */
    protected abstract void initView();


    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        mPresenter.detachView();
    }
}
