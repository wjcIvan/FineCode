package com.app.jieshu.mvp.book.presenter;

import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.base.BasePresenter;
import com.app.jieshu.mvp.book.model.BookModel;
import com.app.jieshu.mvp.book.view.BookView;

import org.json.JSONObject;

/**
 * Created by Administrator on 2019/3/18
 */
public class BookPresenter extends BasePresenter<BookView> {

    BookModel bookModel = new BookModel();

    public void borrow(final int bid, final int nowsid) {
        bookModel.isJie(bid, new BaseCallBack<JSONObject>() {
            @Override
            public void success(JSONObject result) {
                if (result.optString("code").equals("success")) {
                    bookModel.borrow(bid, new BaseCallBack<JSONObject>() {
                        @Override
                        public void success(JSONObject result) {
                            if (result.optString("code").equals("success")) {
                                getView().borrowSuccess();
                                bookModel.update(bid, nowsid, 1);
                            } else {
                                getView().borrowFail(result.optString("msg"));
                            }
                        }

                        @Override
                        public void fail() {
                            getView().borrowFail("接口请求异常");
                        }
                    });
                } else {
                    getView().borrowFail(result.optString("msg"));
                }
            }

            @Override
            public void fail() {
                getView().borrowFail("接口请求异常");
            }
        });


    }


}
