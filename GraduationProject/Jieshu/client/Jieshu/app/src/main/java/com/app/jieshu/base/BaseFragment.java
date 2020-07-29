package com.app.jieshu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends Fragment {

    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
    public void onDestroyView() {
        super.onDestroyView();
        //解除绑定
        mPresenter.detachView();
    }


}
