package wjc.ivan.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;
import wjc.ivan.oschina.activity.BlogActivity;
import wjc.ivan.oschina.bean.BlogBean;
import wjc.ivan.oschina.R;

/**
 * Created by 龙心诚 on 2018/6/26 0026.
 */

public class BlogFragment extends Fragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ItheimaRecyclerView mItheimaRecyclerView;
    private PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_blog,container,false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mItheimaRecyclerView = (ItheimaRecyclerView) view.findViewById(R.id.recycler_view);

        RecyclerViewHeader mRecyclerViewHeader = (RecyclerViewHeader) view.findViewById(R.id.recycler_header);
        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerViewHeader.attachTo(mItheimaRecyclerView);
        RadioGroup mRadioGroup= (RadioGroup) view.findViewById(R.id.rg_blog_head_layout);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.bt_blog_head_recommend:
                        url = "action/apiv2/blog?catalog=3&pageToken=";

                        break;
                    case R.id.bt_blog_head_hot:
                        url = "action/apiv2/blog?catalog=2&nextPageToken=";
                        break;
                    case R.id.bt_blog_new_blog:
                        url = "action/apiv2/blog?catalog=1&nextPageToken=";
                        break;
                }
                initData();
            }
        });
        initData();
        return view;
    }
    String url = "action/apiv2/blog?catalog=3&%20pageToken=";

    private void initData() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<BlogBean>(mSwipeRefreshLayout, mItheimaRecyclerView, BlogActivity.MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_news;
            }
            @Override
            public String getApi() {
                //接口
                return url;
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<BlogBean.ResultBean.ItemsBean> {
        @BindView(R.id.tv_Title)
        TextView mTvTitle;
        @BindView(R.id.tv_description)
        TextView mTvDescription;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_comment_count)
        TextView mTvCommentCount;

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }
        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            mTvTitle.setText(mData.getTitle());
            mTvDescription.setText(mData.getBody());
            mTvTime.setText(mData.getAuthor()+"  "+mData.getPubDate());
            //mTvCommentCount.setText("0");
        }
    }
}
