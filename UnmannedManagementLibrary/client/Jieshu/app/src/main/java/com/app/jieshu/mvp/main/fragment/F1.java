package com.app.jieshu.mvp.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.jieshu.R;
import com.app.jieshu.base.BaseFragment;
import com.app.jieshu.mvp.book.BookListActivity;
import com.app.jieshu.mvp.book.SearchBookActivity;
import com.app.jieshu.mvp.main.presenter.F1Presenter;
import com.app.jieshu.mvp.main.view.F1View;
import com.app.jieshu.util.T;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/3/16
 */
public class F1 extends BaseFragment<F1View, F1Presenter> implements F1View, AdapterView.OnItemClickListener, View.OnClickListener {
    View view;
    ListView lv;
    JSONArray shujiaArr;
    MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1, container, false);
        initView();

        return view;
    }

    @Override
    protected void initView() {
        lv = view.findViewById(R.id.lv);
        view.findViewById(R.id.ivScan).setOnClickListener(this);
        view.findViewById(R.id.tvSearch).setOnClickListener(this);
        lv.setOnItemClickListener(this);
        mPresenter.searchShujia();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int sid = shujiaArr.optJSONObject(position).optInt("sid");
        mPresenter.searchBook(sid);
    }

    @Override
    protected F1Presenter createPresenter() {
        return new F1Presenter();
    }


    @Override
    public void getShujiaSuccess(JSONArray array) {
        shujiaArr = array;
        updateUi();
    }

    @Override
    public void getShujiaFail() {
        shujiaArr = new JSONArray();
        updateUi();
    }

    @Override
    public void getBookSuccess(JSONArray array) {
        startActivity(new Intent(getActivity(), BookListActivity.class).putExtra("book", array.toString()));
    }

    @Override
    public void getBookFail() {
        T.show("该书架暂无书本");
    }

    @Override
    public void ScanSuccess(JSONArray array) {
        startActivity(new Intent(getActivity(), BookListActivity.class).putExtra("book", array.toString()).putExtra("isScan", true));
    }

    @Override
    public void ScanFail() {
        T.show("该书架暂无书本");
    }


    @Override
    public void updateUi() {
        if (adapter == null) {
            adapter = new MyAdapter();
            lv.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvSearch) {
            startActivity(new Intent(getActivity(), SearchBookActivity.class));
        } else {
            startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //处理扫描结果（在界面上显示）
        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                final String result = bundle.getString(CodeUtils.RESULT_STRING);
                if (result.contains("#")) {
                    mPresenter.checkCode(result.split("#")[1]);
                } else {
                    T.show("二维码不正确");
                }
            } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
            }
        }
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return shujiaArr.length();
        }

        @Override
        public Object getItem(int position) {
            return shujiaArr.opt(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.item1, null);
            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvLoc = view.findViewById(R.id.tvLoc);
            JSONObject object = shujiaArr.optJSONObject(position);
            tvName.setText(object.optString("name"));
            tvLoc.setText("书架编号：SJ#" + object.optInt("sid") +
                    "\n所在位置：" + object.optString("loc"));
            return view;
        }
    }
}
