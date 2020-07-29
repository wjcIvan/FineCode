package wjc.ivan.oschina.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.loopviewpager.LoopViewPager;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.itheima.recycler.L;
import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;
import wjc.ivan.oschina.bean.BannerBean;
import wjc.ivan.oschina.activity.DetailActivity;
import wjc.ivan.oschina.activity.MainActivity;
import wjc.ivan.oschina.bean.NewsBean;
import wjc.ivan.oschina.R;

/**
 * Created by 龙心诚 on 2018/6/26 0026.
 */

public class SynthesisFragment extends Fragment{
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    private ItheimaRecyclerView mRecyclerView;
    private LoopViewPager loopViewPager;
    private int state=0;
    private static final int STATE_REFRESH=1;
    private static final int STATE_MORE=2;
    private String nextPageToken="";
    private NewsBean mNewsBean;
    List<NewsBean.ResultBean.ItemsBean> itembeans=new ArrayList<>();
    /*@BindView(R.id.recycler_view)
    ItheimaRecyclerView mRecyclerView;*/
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,container,false);
        ButterKnife.bind(this.getActivity());
        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.recycler_header);
        mRecyclerView = (ItheimaRecyclerView) view.findViewById(R.id.recycler_view);
        header.attachTo(mRecyclerView);
        loopViewPager = (LoopViewPager) view.findViewById(R.id.lvp_pager);
        initBanner();
        ItemClickSupport itemClickSupport = new ItemClickSupport(mRecyclerView);
        //点击事件
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                //Toast.makeText(recyclerView.getContext(), "我被点击了", Toast.LENGTH_SHORT).show();
                int id=itembeans.get(position).getId();
                Intent intent=new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>
            (mSwipeRefreshLayout, mRecyclerView, MainActivity.MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_news;
            }
            @Override
            public String getApi() {
                String url="action/apiv2/news?pageToken=";
                switch (state){
                    case STATE_REFRESH:
                        break;
                    case STATE_MORE:
                        nextPageToken=mNewsBean.getResult().getNextPageToken();
                        url+= nextPageToken;
                        break;
                }
                //接口
                return url;
            }
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                state=STATE_MORE;
                return true;
            }
        };
        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<NewsBean>() {
        @Override
        public void onRefresh() {
            //监听下拉刷新，如果不需要监听可以不重新该方法
            L.i("setLoadingDataListener onRefresh");
            state=STATE_REFRESH;
        }
        @Override
        public void onSuccess(NewsBean newsBean , Headers headers) {
            //监听http请求成功，如果不需要监听可以不重新该方法
            L.i("setLoadingDataListener onSuccess: " + newsBean);
            mNewsBean=newsBean;
            List<NewsBean.ResultBean.ItemsBean> itemDatas=newsBean.getItemDatas();
            for(NewsBean.ResultBean.ItemsBean itemData :itemDatas){
                itembeans.add(itemData);
            }
        }
    });
    //开始请求
        pullToLoadMoreRecyclerView.requestData();
        return view;
    }
    List<String> imageLists=new ArrayList<>();
    List<String> textLists=new ArrayList<>();
    private void initBanner() {
        Request request = ItheimaHttp.newGetRequest("action/apiv2/banner?catalog=1");
        Call call = ItheimaHttp.send(request, new HttpResponseListener<BannerBean>() {
            @Override
            public void onResponse(BannerBean bannerBean, Headers headers) {
                List<BannerBean.ResultBean.ItemsBean> itemDatas=bannerBean.getItemDatas();
                for (int i=0;i<itemDatas.size();i++){
                    textLists.add(itemDatas.get(i).getName());
                    imageLists.add(itemDatas.get(i).getImg());
                    //Log.i("img",itemDatas.get(i).getImg());
                }
                loopViewPager.setImgData(imageLists);
                loopViewPager.setTitleData(textLists);
                loopViewPager.start();
            }
        });
    }
    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.ResultBean.ItemsBean> {
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
            mTvTime.setText(mData.getPubDate());
            mTvCommentCount.setText(mData.getCommentCount()+"");
        }
    }
}

