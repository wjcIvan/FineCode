package com.app.jieshu.mvp.book.model;

import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.util.MyCallBack;
import com.app.jieshu.util.S;
import com.app.jieshu.util.T;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/18
 */
public class BookModel {

    public void borrow(int bid, final BaseCallBack<JSONObject> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("bid", bid + "");
        map.put("uid", S.getU().getUid() + "");
        map.put("statu", 0 + "");
        map.put("time", T.getTime());
        OkGo.<JSONObject>post(Ip.BORROW + "save").params(map).execute(new MyCallBack() {

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

    public void isJie(int bid, final BaseCallBack<JSONObject> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("bid", bid + "");
        OkGo.<JSONObject>post(Ip.BOOK + "isjie").params(map).execute(new MyCallBack() {

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

    public void update(int bid, int nowsid, int statu) {
        Map<String, String> map = new HashMap<>();
        map.put("bid", bid + "");
        map.put("nowsid", nowsid + "");
        map.put("statu", statu + "");
        OkGo.<JSONObject>post(Ip.BOOK + "update").params(map).execute(new MyCallBack() {
            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
            }
            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
            }
        });
    }

    public void updateBorrowStatu(int brid, int statu) {
        Map<String, String> map = new HashMap<>();
        map.put("brid", brid + "");
        map.put("statu", statu + "");
        OkGo.<JSONObject>post(Ip.BORROW + "updateStatu").params(map).execute(new MyCallBack() {
            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
            }

            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
            }
        });
    }

    public void updateUserXY() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", S.getU().getUid() + "");
        map.put("credit", S.getU().getCredit() + "");
        OkGo.<JSONObject>post(Ip.USER + "updateXY").params(map).execute(new MyCallBack() {

            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
            }

            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
            }
        });
    }

}
