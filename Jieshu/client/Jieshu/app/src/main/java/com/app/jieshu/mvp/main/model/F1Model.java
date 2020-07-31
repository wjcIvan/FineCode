package com.app.jieshu.mvp.main.model;

import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.bean.Ip;
import com.app.jieshu.util.MyCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/3/16
 */
public class F1Model {


    /**
     * 查询所有书架
     *
     * @param callBack
     */
    public void searchShuJia(final BaseCallBack<JSONArray> callBack) {
        OkGo.<JSONObject>get(Ip.SHUJIA + "search").execute(new MyCallBack() {

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

    public void searchShuJiaOne(int sid, final BaseCallBack<JSONObject> callBack) {
        OkGo.<JSONObject>get(Ip.SHUJIA + "searchsid").params("sid", sid).execute(new MyCallBack() {

            @Override
            public void onSuccess(Response<JSONObject> response) {
                super.onSuccess(response);
                JSONObject object = response.body();
                if (object.optString("code").equals("success")) {
                    callBack.success(object.optJSONObject("data"));
                } else {
                    callBack.fail();
                }

            }
        });
    }

    /**
     * 根据书架查询书本
     *
     * @param nowsid
     * @param callBack
     */
    public void searchBook(int nowsid, final BaseCallBack<JSONArray> callBack) {
        OkGo.<JSONObject>get(Ip.BOOK + "search").params("nowsid", nowsid).execute(new MyCallBack() {
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


}
