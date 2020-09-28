package com.app.jieshu.mvp.main.presenter;

import com.app.jieshu.base.BaseCallBack;
import com.app.jieshu.base.BasePresenter;
import com.app.jieshu.mvp.book.model.BookModel;
import com.app.jieshu.mvp.main.model.F1Model;
import com.app.jieshu.mvp.main.model.F2Model;
import com.app.jieshu.mvp.main.view.F2View;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/3/18
 */
public class F2Presenter extends BasePresenter<F2View> {

    F2Model f2Model = new F2Model();
    BookModel bookModel = new BookModel();
    F1Model f1Model = new F1Model();

    public void search(int statu) {

        f2Model.search(statu, new BaseCallBack<JSONArray>() {
            @Override
            public void success(JSONArray result) {
                getView().getSuccess(result);
            }

            @Override
            public void fail() {
                getView().getFail();
            }
        });

    }

    public void huanshu(final int sid, final int bid, final int brid) {
        f1Model.searchShuJiaOne(sid, new BaseCallBack<JSONObject>() {
            @Override
            public void success(JSONObject result) {
                //修改书本状态,为可借
                bookModel.update(bid, sid, 0);
                //修改订单状态
                bookModel.updateBorrowStatu(brid, 1);
                //修改用户信用值
                bookModel.updateUserXY();
                getView().getHuanshuSuccess();
            }


            @Override
            public void fail() {
                getView().getHuanshuFail();
            }
        });
    }

    public void delete(int brid) {
        f2Model.delete(brid);
        getView().deleteSuccess();
    }


}
