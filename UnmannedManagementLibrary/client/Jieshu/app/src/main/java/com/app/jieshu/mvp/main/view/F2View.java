package com.app.jieshu.mvp.main.view;

import org.json.JSONArray;

/**
 * Created by Administrator on 2019/3/18
 */
public interface F2View {

    void getSuccess(JSONArray array);

    void getFail();
    void getHuanshuSuccess();

    void getHuanshuFail();

    void deleteSuccess();
}
