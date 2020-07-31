package com.app.jieshu.mvp.book;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.jieshu.R;
import com.app.jieshu.base.BaseActivity;
import com.app.jieshu.mvp.book.presenter.BookPresenter;
import com.app.jieshu.mvp.book.view.BookView;
import com.app.jieshu.util.T;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 书本详情界面
 */
public class BookMsgActivity extends BaseActivity<BookView, BookPresenter> implements BookView, View.OnClickListener {
    ImageView iv;
    TextView tvName, tv1, tv2, tv3, tvContent, tvJie;
    ListView lv;
    JSONObject object;
    boolean isScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_msg);
        initView();

    }

    @Override
    protected void initView() {
        tvJie = findViewById(R.id.tvJie);
        try {
            object = new JSONObject(getIntent().getStringExtra("object"));
            isScan = getIntent().getBooleanExtra("isScan", false);
            tvJie.setVisibility(isScan ? View.VISIBLE : View.GONE);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        iv = findViewById(R.id.iv);
        tvName = findViewById(R.id.tvName);
        tvContent = findViewById(R.id.tvContent);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        lv = findViewById(R.id.lv);

        tvName.setText(object.optString("bname"));
        tvContent.setText(object.optString("sumary"));
        tv1.setText("作者：" + object.optString("author"));
        tv2.setText("ISBN：" + object.optString("isbn"));
        tv3.setText(" " + (object.optInt("statu") == 0 ? "可借" : "已被借") + " ");
        String img = object.optString("img");
        Picasso.with(this).load(img).resize(100, 100).centerCrop().into(iv);

        findViewById(R.id.layout_back).setOnClickListener(this);
        findViewById(R.id.tvJie).setOnClickListener(this);
    }

    @Override
    protected BookPresenter createPresenter() {
        return new BookPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_back:
                finish();
                break;
            case R.id.tvJie:
                mPresenter.borrow(object.optInt("bid"), object.optInt("nowsid"));
                break;
        }
    }

    @Override
    public void borrowSuccess() {
        T.show("借书成功");
        tv3.setText(" " + "已被借" + " ");
    }

    @Override
    public void borrowFail(String result) {
        T.show(result);
    }
}
