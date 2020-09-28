package com.app.jieshu.mvp.main.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.jieshu.R;
import com.app.jieshu.base.BaseFragment;
import com.app.jieshu.bean.User;
import com.app.jieshu.mvp.main.presenter.F2Presenter;
import com.app.jieshu.mvp.main.view.F2View;
import com.app.jieshu.util.S;
import com.app.jieshu.util.T;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * 界面
 *
 * @author Administrator
 */
public class F2_item extends BaseFragment<F2View, F2Presenter> implements F2View {
    View view;
    ListView lv;
    JSONArray array;
    private MyAdapter adapter;
    int statu = -1;
    public RefreshLayout refreshLayout;
    int uid;
    JSONObject obj;

    public static F2_item getInstence(int statu) {
        Bundle bundle = new Bundle();
        bundle.putInt("statu", statu);
        F2_item f2 = new F2_item();
        f2.setArguments(bundle);
        return f2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f2_item, container, false);
        initView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                if (statu == 0) {
                    new AlertDialog.Builder(getActivity()).setTitle("是否归还书本？").setPositiveButton("归还", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            obj = array.optJSONObject(position);
                            startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 2);
                        }
                    }).setNegativeButton("取消", null).show();
                } else {
                    new AlertDialog.Builder(getActivity()).setTitle("是否删除借书记录？").setPositiveButton("删除", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            obj = array.optJSONObject(position);
                            mPresenter.delete(obj.optInt("brid"));
                        }
                    }).setNegativeButton("取消", null).show();
                }


            }
        });
        return view;
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
                    //还书//判断这个书架是否存在//修改单子状态//修改书本状态//判断是否是原书架，是 信用+1
                    int sid = Integer.parseInt(result.split("#")[1]);
                    if (sid == obj.optInt("sid")) {//判断是否是原来的书架，信用+1
                        int c = S.getU().getCredit() + 1;
                        User user = S.getU();
                        user.setCredit(c);
                        S.setU(user);
                    }
                    mPresenter.huanshu(sid, obj.optInt("bid"), obj.optInt("brid"));
                } else {
                    T.show("二维码不正确");
                }
            } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        get();
    }

    public void get() {
        mPresenter.search(statu);
    }


    @Override
    protected void initView() {
        uid = S.getU().getUid();
        statu = getArguments().getInt("statu");
        lv = (ListView) view.findViewById(R.id.lv);
        refreshLayout = (RefreshLayout) view.findViewById(R.id.refreshLayout);
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.search(statu);
            }
        });
    }

    @Override
    protected F2Presenter createPresenter() {
        return new F2Presenter();
    }

    @Override
    public void getSuccess(JSONArray arr) {

        array = arr;
        lv.setAdapter(new MyAdapter());
        refreshLayout.finishRefresh(500);
    }

    @Override
    public void getFail() {
        refreshLayout.finishRefresh(500);
        array = new JSONArray();
        lv.setAdapter(new MyAdapter());
    }

    @Override
    public void getHuanshuSuccess() {
        T.show("还书成功");
        mPresenter.search(statu);
        get();
        ((F2) (F2_item.this.getParentFragment())).updateUi();
    }

    @Override
    public void getHuanshuFail() {
        T.show("没有这个书架");
    }

    @Override
    public void deleteSuccess() {
        T.show("删除成功");
        get();
    }

    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return array.length();
        }

        @Override
        public Object getItem(int position) {
            return array.opt(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final JSONObject object = array.optJSONObject(position);
            Holder holder = null;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.item3, null);
                holder = new Holder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            String bname = object.optString("bname");
            final int statu = object.optInt("statu");


            holder.tv0.setText("书名：" + bname);
            holder.tv1.setText("所属书架：" + object.optString("name")+"\n书架编号：SJ#" + object.optInt("sid"));
            holder.tv2.setText("借书时间：" + object.optString("time"));

            String img = object.optString("img");
            Picasso.with(getActivity()).load(img).resize(100, 100).centerCrop().into(holder.iv);
            return convertView;
        }
    }

    class Holder {
        ImageView iv;
        TextView tv0, tv1, tv2;

        public Holder(View item) {
            this.iv = item.findViewById(R.id.iv);
            this.tv0 = item.findViewById(R.id.tv0);
            this.tv1 = item.findViewById(R.id.tv1);
            this.tv2 = item.findViewById(R.id.tv2);
        }
    }


}
