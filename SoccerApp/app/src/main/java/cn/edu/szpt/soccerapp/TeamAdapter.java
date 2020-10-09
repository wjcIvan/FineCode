package cn.edu.szpt.soccerapp;

import android.content.Context;
import android.graphics.Bitmap;

import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 2018/6/25.
 */

public class TeamAdapter extends BaseAdapter {
    private List<TeamBean> list;
    private Context context;
    private LruCache<String,Bitmap> cache;

    public TeamAdapter(List<TeamBean> list, Context context, LruCache<String, Bitmap> cache) {
        this.list = list;
        this.context = context;
        this.cache = cache;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_team,parent,false);
        }
        TextView tvCountry= (TextView) convertView.findViewById(R.id.tvCountry);
        TextView tvCount= (TextView) convertView.findViewById(R.id.tvCount);
        ImageView ivFlag= (ImageView) convertView.findViewById(R.id.ivFlag);
        TeamBean bean=list.get(position);
        tvCountry.setText(bean.getCountry());
        tvCount.setText(bean.getVotenum());
        Bitmap bmp=cache.get(bean.getFlag());
        if(bmp==null) {
            ivFlag.setTag(bean.getCountry());
            new imgGetTask(ivFlag, bean.getCountry(),cache).execute("http://10.1.102.44/images/", bean.getFlag());
        }else{
            ivFlag.setImageBitmap(bmp);
        }
        return convertView;
    }
}
