package com.app.jieshu.mvp.main.model;

import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.util.MyCallBack;
import com.app.jieshu.util.S;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/3/18
 */
public class F2Model {


    /**
     * 查询借书记录
     */
    public void search(int statu, final BaseCallBack<JSONArray> callBack) {
        OkGo.<JSONObject>get(Ip.BORROW + "search").params("uid", S.getU().getUid()).params("statu", statu).execute(new MyCallBack() {

            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
                JSONObject object = response.body();
                if (object.optString("code").equals("success")) {
                    callBack.success(object.optJSONArray("data"));
                } else {
                    callBack.fail();
                }

            }
        });
    }

    public void delete(int brid) {
        OkGo.<JSONObject>get(Ip.BORROW + "delete").params("brid", brid).execute(new MyCallBack() {

            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);

            }
        });
    }


}
