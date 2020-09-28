package com.app.jieshu.mvp.main.view;

import org.json.JSONArray;

/**
 * Created by Administrator on 2019/3/16
 */
public interface F1View {

    void getShujiaSuccess(JSONArray array);

    void getShujiaFail();

    void getBookSuccess(JSONArray array);

    void getBookFail();

    void updateUi();

    void ScanSuccess(JSONArray array);

    void ScanFail();

}
