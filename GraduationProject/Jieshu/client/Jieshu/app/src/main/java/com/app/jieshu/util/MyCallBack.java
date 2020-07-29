package com.app.jieshu.util;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;


public class MyCallBack extends AbsCallback<JSONObject> {
    @Override
    public void onSuccess(Response<JSONObject> response) {

    }

    @Override
    public void onError(Response<JSONObject> response) {
        super.onError(response);
    }

    @Override
    public JSONObject convertResponse(okhttp3.Response response) throws Throwable {
        String obj = response.body().string();
        return new JSONObject(obj);
    }
}
