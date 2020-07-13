package wjc.ivan.oschina.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;
import wjc.ivan.oschina.R;
import wjc.ivan.oschina.bean.DetailBean;

/**
 * Created by 龙心诚 on 2018/6/26 0026.
 */

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.tv_new_detail_soft_title)
    TextView tvNewDetailSoftTitle;
    @BindView(R.id.tv_new_detail_pub_date)
    TextView mTvNewDetailPubDate;
    @BindView(R.id.wv_new_detail_web)
    WebView mWvNewDetailWeb;
    @BindView(R.id.tv_new_detail_name)
    TextView mTvNewDetailName;
    @BindView(R.id.ll_detail_about_softs)
    LinearLayout mLl_detail_about_softs;
    @BindView(R.id.tv_new_detail_related_title)
    TextView tvNewDetailRelatedTitle;
    @BindView(R.id.tv_new_detail_comment)
    TextView tvNewDetailComment;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        setContentView(R.layout.new_detail_activity);
        ButterKnife.bind(this);
        Request request = ItheimaHttp.newGetRequest("action/apiv2/news?id=" + id);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<DetailBean>() {
            @Override
            public void onResponse(DetailBean detailBean, Headers headers) {
                mTvNewDetailName.setText(detailBean.getResult().getTitle());
                mTvNewDetailPubDate.setText(detailBean.getResult().getPubDate());
                //webView的特殊写法,不然会乱码
                /*mWvNewDetailWeb.getSettings().setDefaultTextEncodingName("UTF -8");
                mWvNewDetailWeb.loadData(detailBean.getResult().getBody(),"text/html; charset=UTF-8", null);*/
                mWvNewDetailWeb.loadDataWithBaseURL(null, detailBean.getResult().getBody(), "", "UTF -8", null);

                List<DetailBean.ResultBean.AboutsBean> aboutsBeen = detailBean.getResult().getAbouts();
                if (aboutsBeen.size() > 0 || aboutsBeen != null) {
                    for (int i = 0; i < aboutsBeen.size(); i++) {
                        View view = View.inflate(DetailActivity.this, R.layout.item_about_safe, null);
                        TextView mTextView = (TextView) view.findViewById(R.id.tv_item_about_safe_name);
                        mTextView.setText(aboutsBeen.get(i).getTitle());
                        mLl_detail_about_softs.addView(view);
                    }
                }
            }

            ;
        });


    }

}
