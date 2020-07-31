package com.app.jieshu.base;

import java.lang.ref.WeakReference;


public class BasePresenter<V> {


    protected WeakReference<V> mViewReference;//弱引用


    public void attachView(V view) {
        mViewReference = new WeakReference<V>(view);
    }

    public void detachView() {
        if (mViewReference != null) {
            mViewReference.clear();
        }
    }

    protected V getView() {
        return mViewReference.get();
    }


}
