package com.app.jieshu.mvp.main.presenter;

import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.base.BasePresenter;
import com.app.jieshu.mvp.main.model.F1Model;
import com.app.jieshu.mvp.main.view.F1View;

import org.json.JSONArray;

/**
 * Created by Administrator on 2019/3/16
 */
public class F1Presenter extends BasePresenter<F1View> {

    F1Model f1Model = new F1Model();

    public void searchShujia() {

        f1Model.searchShuJia(new BaseCallBack<JSONArray>() {
            @Override
            public void success(JSONArray result) {
                getView().getShujiaSuccess(result);
            }

            @Override
            public void fail() {
                getView().getShujiaFail();
            }
        });

    }

    public void searchBook(int nowsid) {

        f1Model.searchBook(nowsid, new BaseCallBack<JSONArray>() {
            @Override
            public void success(JSONArray result) {
                getView().getBookSuccess(result);
            }

            @Override
            public void fail() {
                getView().getBookFail();
            }
        });

    }


    public void checkCode(String scanResult){
        f1Model.searchBook(Integer.parseInt(scanResult), new BaseCallBack<JSONArray>() {
            @Override
            public void success(JSONArray result) {
                getView().ScanSuccess(result);
            }

            @Override
            public void fail() {
                getView().ScanFail();
            }
        });
    }
}
